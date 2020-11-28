package com.example.realkepstone.ui.slideshow;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.realkepstone.MainActivity;
import com.example.realkepstone.R;
import com.example.realkepstone.data.FoodAfter;
import com.example.realkepstone.server.ApiInterface;
import com.example.realkepstone.server.HttpClient;
import com.example.realkepstone.ui.ResultFragment;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.widget.Toast.makeText;

public class MenuSlideFragment extends Fragment {
    private static final int PICK_FROM_CAMERA = 2;
    ImageView imageView; // 이미지 미리보기\
    private Boolean isPermission = true;
    private File tempFile; // 보낼 사진 File의 껍데기, 앨범 또는 카메라에서 가져온 이미지를 저장할 변수.
    ApiInterface apiInterface;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_menuslide, container, false);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).connectTimeout(1000, TimeUnit.MINUTES)
                .readTimeout(1000000, TimeUnit.SECONDS)
                .writeTimeout(1000000, TimeUnit.SECONDS).build();

        apiInterface = HttpClient.getRetrofit().create( ApiInterface.class );

        tedPermission();
        imageView = root.findViewById(R.id.iv2);


        imageView.setOnClickListener(new Button.OnClickListener() { // 버튼 onClick 리스너 처리부분
            @Override public void onClick( View v ) {
                if(isPermission)
                    takePhoto();
                else makeText( getActivity().getApplicationContext(), getResources().getString(R.string.navigation_drawer_close), Toast.LENGTH_SHORT).show();
            }
        }); // 사진 가져오기 버튼에 리스너 추가


        return root;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        /* 카메라를 켰다 사진을 안찍거나, 앨범에 가서 사진을 안 골라 온 경우의 예외 처리 */
        if (resultCode != Activity.RESULT_OK) {
            makeText(getContext(), R.string.cancel, Toast.LENGTH_SHORT).show();
            if (tempFile != null) {
                if (tempFile.exists()) {
                    if (tempFile.delete()) {
                        tempFile = null;
                    }
                }
            }
            return;
        }
        /* 카메라를 켰다 사진을 안찍거나, 앨범에 가서 사진을 안 골라 온 경우의 예외 처리 */ /* onActivityResult의 requestCode 값에 따라 로직이 실행됨 */

        setImage();


        RequestBody reqFile = RequestBody.create(MediaType.parse("multipart/form-file"), tempFile);
        MultipartBody.Part body = MultipartBody.Part.createFormData("file", tempFile.getName(), reqFile);
        RequestBody name = RequestBody.create(MediaType.parse("image/jpeg"), "file");

//            Log.d("THIS", data.getData().getPath());
        retrofit2.Call<FoodAfter> req = apiInterface.postImage(body, name);
        req.enqueue(new Callback<FoodAfter>() {
            @Override
            public void onResponse(Call<FoodAfter> call, Response<FoodAfter> response) {
                if(response.code()==201) {
                    response.body(); // have your all data
                       /* List<String> id = response.body().getFoodKorName();
                        List<String> engName = response.body().getFoodEngName();
                        List<String> descreption = response.body().getFoodDescription();
                        List<List<String>> ingredients = response.body().getFoodIngredients();
                        List<List<String>> allergy = response.body().getFoodAllergy();
                        text.setText(id+"+"+engName+"+"+descreption);*/
                    //Put the value
                    FragmentTransaction transaction=getActivity().getSupportFragmentManager().beginTransaction();
                    ResultFragment mfragment=new ResultFragment();

                    Bundle bundle=new Bundle();
                    //  bundle.putSerializable("json", response.body());

                    bundle.putSerializable("json", response.body());

                    mfragment.setArguments(bundle); //data being send to SecondFragment
                    transaction.replace(R.id.Main_Frame, mfragment,"not");
                    transaction.commit();
                    //  MainActivity activity = (MainActivity) getActivity();
                    // activity.setFrag(4);
                }
                Log.d("TedPark", String.valueOf(response.code()));
            }
            @Override
            public void onFailure(Call<FoodAfter> call, Throwable t) {
                t.printStackTrace();
                Log.d("TedPark", "ㄹ");
                Toast.makeText(getContext().getApplicationContext(), R.string.network, Toast.LENGTH_LONG).show();

            }
        });




    }



    private void tedPermission() {
        PermissionListener permissionListener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
            }
            @Override
            public void onPermissionDenied(ArrayList<String> deniedPermissions) {
                makeText(getActivity().getApplicationContext(), R.string.cancel, Toast.LENGTH_LONG).show(); // 권한 요청 실패
            }
        };
        TedPermission.with(getContext())
                .setPermissionListener(permissionListener)
                .setDeniedMessage(getResources().getString(R.string.menu_gallery))
                .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA)
                .check(); }

    private void takePhoto() { // Intent를 이용해 Camera로 이동함.
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            tempFile = createImageFile();
        } catch (IOException e) {
            makeText(getActivity().getApplicationContext(), R.string.cancel, Toast.LENGTH_LONG).show(); // 권한 요청 실패
            e.printStackTrace();
        }
        if (tempFile != null) { /** tempFile 의 Uri 경로를 intent에 추가해 줘야 함. * 카메라에서 찍은 사진이 저장될 주소임. * tempFile 을 전역변수로 해서 사용하기 때문에 이 tempFile 에 카메라에서 촬영한 이미지를 넣어 줄것임. */ //
        // Android 버전에 맞춰서 작업 함.
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            Uri photoUri = FileProvider.getUriForFile(getContext(), "com.example.realkepstone", tempFile);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
            startActivityForResult(intent, PICK_FROM_CAMERA);
            }
            else {
                Uri photoUri = Uri.fromFile(tempFile);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                startActivityForResult(intent, PICK_FROM_CAMERA);
            }
        }
    } /* 카메라에서 이미지를 가져오기 위한 method */


    private void setImage() {
        ImageView imageView = getActivity().findViewById(R.id.iv2);
        BitmapFactory.Options options = new BitmapFactory.Options();
        Bitmap originalBm = BitmapFactory.decodeFile(tempFile.getAbsolutePath(), options);
        imageView.setImageBitmap(originalBm);
    }
    private File createImageFile() throws IOException {
        // 이미지 파일 이름 ( Yummy_{시간}_ )
        @SuppressLint("SimpleDateFormat") String timeStamp = new SimpleDateFormat("HHmmss").format(new Date());
        String imageFileName = "Yummy_" + timeStamp + "_";
        // 이미지가 저장될 폴더 이름
        File storageDir = new File(Environment.getExternalStorageDirectory() + "/DCIM/Camera/");
        if (!storageDir.exists()) { storageDir.mkdirs();
        } // 빈 파일 생성
        return File.createTempFile( imageFileName, /* prefix */ ".jpg", /* suffix */ storageDir /* directory*/ );
    } /* 카메라에서 찍어온 사진을 저장할 파일 만들기 */


}