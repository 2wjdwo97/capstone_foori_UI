package com.example.realkepstone.ui.gallery;
//
import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.realkepstone.FoodListActivity;
import com.example.realkepstone.MainActivity;
import com.example.realkepstone.MenuRecogActivity;
import com.example.realkepstone.R;
import com.example.realkepstone.SharedViewModel;
import com.example.realkepstone.data.Food;
import com.example.realkepstone.data.FoodAfter;
import com.example.realkepstone.server.ApiInterface;
import com.example.realkepstone.server.HttpClient;
import com.example.realkepstone.ui.ResultFragment;
import com.google.gson.JsonObject;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

public class MenuGalleryFragment extends Fragment {
    public static final int PICK_IMAGE = 100;
    private final int GET_GALLERY_IMAGE = 200;

    private MainActivity activity;
    private SharedViewModel model;
    private ImageView imageview;
    private ApiInterface apiInterface;
    private Boolean isPermission = true;
    private String token;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_menugallery, container, false);

        model = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        token=model.getToken();
        Log.d("MenuGallergyFrag_token", String.valueOf(token));

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).connectTimeout(1000, TimeUnit.MINUTES)
                .readTimeout(1000000, TimeUnit.SECONDS)
                .writeTimeout(1000000, TimeUnit.SECONDS).build();

        tedPermission();

        apiInterface = HttpClient.getRetrofit().create( ApiInterface.class );
        imageview = (ImageView) root.findViewById(R.id.imageView);

        if(isPermission){
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select Image"), PICK_IMAGE);
        }
        else makeText( getActivity().getApplicationContext(), getResources().getString(R.string.cancel), Toast.LENGTH_SHORT).show();
        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isPermission){
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(Intent.createChooser(intent, "Select Image"), PICK_IMAGE);
                }
                else makeText( getActivity().getApplicationContext(), getResources().getString(R.string.cancel), Toast.LENGTH_SHORT).show();


            }
        });

        return root;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        imageview.setImageResource(R.drawable.loading_2);
        Animation a = AnimationUtils.loadAnimation(getContext(), R.anim.progress_anim);
        a.setDuration(1000);
        imageview.startAnimation(a);

        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK) {

            android.net.Uri selectedImage = data.getData();

            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            activity = (MainActivity) getActivity();
            String filePath=activity.getRealPathFromURI(selectedImage);
            File file = new File(filePath);
            Log.d("TedPark", filePath);


            RequestBody reqFile = RequestBody.create(MediaType.parse("multipart/form-file"), file);
            MultipartBody.Part body = MultipartBody.Part.createFormData("file", file.getName(), reqFile);
            RequestBody name = RequestBody.create(MediaType.parse("image/jpeg"), "file");

//            Log.d("THIS", data.getData().getPath());
            retrofit2.Call<FoodAfter> req = apiInterface.postImage(token, body, name);
            Log.d("MenuGallergyFrag_token", String.valueOf(token));
            req.enqueue(new Callback<FoodAfter>() {
                @Override
                public void onResponse(Call<FoodAfter> call, Response<FoodAfter> response) {
                    if(response.code()==201) {

                        imageview.clearAnimation();


                        response.body(); // have your all data
                        Log.e("list" , response.body().getFoodKorName()+"Kor");
                        Log.e("list" , response.body().getFoodEngName()+"Eng");
                        Log.e("list" , response.body().getFoodAllergy()+"allergy");
                        Log.e("list" , response.body().getFoodDescription()+"dest");
                        Log.e("list" , response.body().getFoodImgUrl()+"url");
                        Log.e("list" , response.body().getFoodIngredients()+"ingre");
                        Log.e("list" , response.body().getStar()+"star");

                        Log.e("list" , response.body().getRecommendFood()+"recommend");
                        Log.e("list" , response.body().getCookies()+"cookies");


                        //Put the value
                        change(response.body());

//                        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
//                        ResultFragment mfragment = new ResultFragment();
//
//                        Bundle bundle=new Bundle();
//                        bundle.putSerializable("json", response.body());
//
//                        bundle.putSerializable("json", response.body());
//
//                        mfragment.setArguments(bundle); //data being send to SecondFragment
//                        transaction.replace(R.id.Main_Frame, mfragment,"not");
//                        transaction.commit();
                        Log.d("TedPark", String.valueOf(response.code()));

                    }else{
                        imageview.clearAnimation();
                        imageview.setImageResource(R.drawable.no_data);
                    }
                    Log.d("TedPark", String.valueOf(response.code()));
                }
                @Override
                public void onFailure(Call<FoodAfter> call, Throwable t) {

                    imageview.clearAnimation();
                    imageview.setImageResource(R.drawable.no_data);

                    t.printStackTrace();
                    Log.d("TedPark", "ㄹ");
                    Toast.makeText(getContext().getApplicationContext(), getResources().getString(R.string.network), Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    public void change(FoodAfter res_body) {
        Intent intent = new Intent(activity, MenuRecogActivity.class);
        intent.putExtra("json", res_body);
        startActivity(intent);
        activity.overridePendingTransition(R.anim.enter_from_right, R.anim.enter_from_right);
    }

    private void tedPermission() {
        PermissionListener permissionListener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
            }
            @Override
            public void onPermissionDenied(ArrayList<String> deniedPermissions) {
                makeText(getActivity().getApplicationContext(), getResources().getString(R.string.cancel), Toast.LENGTH_LONG).show(); // 권한 요청 실패
            }
        };
        TedPermission.with(getContext())
                .setPermissionListener(permissionListener)
                .setDeniedMessage(getResources().getString(R.string.menu_gallery))
                .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA)
                .check();
    }
}