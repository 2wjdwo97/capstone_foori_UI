package com.example.realkepstone;

import android.view.MenuItem;
import android.widget.ImageView;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Log;

import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.realkepstone.ui.BagFragment;
import com.example.realkepstone.ui.OrderFragment;
import com.example.realkepstone.ui.ResultFragment;
import com.example.realkepstone.ui.ReviewFragment;
import com.example.realkepstone.ui.ReviewTagFragment;
import com.example.realkepstone.ui.gallery.GalleryFragment;
import com.example.realkepstone.ui.gallery.MenuGalleryFragment;
import com.example.realkepstone.ui.mypage.ChangePWFragment;
import com.example.realkepstone.ui.mypage.ChangeTagFragment;
import com.example.realkepstone.ui.mypage.LanguageFragment;
import com.example.realkepstone.ui.mypage.QuitFragment;
import com.example.realkepstone.ui.mypage.ReviewsFragment;
import com.example.realkepstone.ui.slideshow.MenuSlideFragment;
import com.example.realkepstone.ui.slideshow.SlideshowFragment;
import com.example.realkepstone.ui.home.HomeFragment;
import com.example.realkepstone.ui.mypage.MypageFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    private ImageView img_toolbar;
    private Toolbar toolbar;

    private ImageView img_home;
    private ImageView img_review;
    private ImageView img_camera;
    private ImageView img_gallery;
    private ImageView img_myPage;

    private FragmentManager fm;
    private FragmentTransaction ft;

    private HomeFragment frag1;
    private SlideshowFragment frag2;
    private GalleryFragment frag3;
    private MypageFragment frag4;
    private ResultFragment frag5;
    private BagFragment frag6;
    private OrderFragment frag7;
    private ReviewFragment frag8;
    private ReviewTagFragment frag9;
    private ChangePWFragment frag10;
    private ChangeTagFragment frag11;
    private QuitFragment frag12;
    private ReviewsFragment frag13;
    private LanguageFragment frag14;
    private MenuSlideFragment frag15;
    private MenuGalleryFragment frag16;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //  GalleryFragment frag3 = (GalleryFragment)getSupportFragmentManager().findFragmentById(R.id.gallery);
        //    frag3.onActivityResult(requestCode,resultCode,data);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this.getIntent());
        int user_no  = intent.getIntExtra("user_no", 0);
        String token = intent.getStringExtra("token");

        SharedViewModel model = new ViewModelProvider(this).get(SharedViewModel.class);
        model.setUser_no(user_no);
        model.setToken(token);
        Log.d("세팅", String.valueOf(model.getUser_no()));
        Log.d("세팅", String.valueOf(model.getToken()));

        if (savedInstanceState != null) {
            //Restore the fragment's instance
            frag5 = (ResultFragment) getSupportFragmentManager().getFragment(savedInstanceState, "Result");
        }

        toolbar = (Toolbar)findViewById(R.id.tb_main);
        setSupportActionBar(toolbar);



        //bottomNavigationView = findViewById(R.id.bottomNavi);

        img_camera = findViewById(R.id.img_camera);
        img_gallery = findViewById(R.id.img_gallery);
        img_home = findViewById(R.id.img_home);
        img_myPage = findViewById(R.id.img_myPage);
        img_review = findViewById(R.id.img_review);

        //     viewPager = findViewById(R.id.viewPager);

        frag1=new HomeFragment();
        frag2=new SlideshowFragment();
        frag3=new GalleryFragment();
        frag4=new MypageFragment();
        frag5=new ResultFragment();
        frag6=new BagFragment();
        frag7=new OrderFragment();
        frag8=new ReviewFragment();
        frag9=new ReviewTagFragment();
        frag10=new ChangePWFragment();
        frag11=new ChangeTagFragment();
        frag12=new QuitFragment();
        frag13=new ReviewsFragment();
        frag14=new LanguageFragment();
        frag15=new MenuSlideFragment();
        frag16=new MenuGalleryFragment();

        img_review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img_review.setImageResource(R.drawable.review_sel_04);
                img_myPage.setImageResource(R.drawable.my_page_05);
                img_home.setImageResource(R.drawable.home_03);
                img_gallery.setImageResource(R.drawable.gallery_gallery);
                setFrag(7);
            }
        });
        img_myPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img_review.setImageResource(R.drawable.review_04);
                img_myPage.setImageResource(R.drawable.my_page_sel_05);
                img_home.setImageResource(R.drawable.home_03);
                img_gallery.setImageResource(R.drawable.gallery_gallery);
                setFrag(3);
            }
        });
        img_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img_review.setImageResource(R.drawable.review_04);
                img_myPage.setImageResource(R.drawable.my_page_05);
                img_home.setImageResource(R.drawable.home_sel_03);
                img_gallery.setImageResource(R.drawable.gallery_gallery);
                setFrag(0);

            }
        });
        img_gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img_review.setImageResource(R.drawable.review_04);
                img_myPage.setImageResource(R.drawable.my_page_05);
                img_home.setImageResource(R.drawable.home_03);
                img_gallery.setImageResource(R.drawable.gallery_sel_gallery);
                setFrag(15);
            }
        });
        img_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img_review.setImageResource(R.drawable.review_04);
                img_myPage.setImageResource(R.drawable.my_page_05);
                img_home.setImageResource(R.drawable.home_03);
                img_gallery.setImageResource(R.drawable.gallery_gallery);
                setFrag(14);
            }
        });

        setFrag(0); // 첫 프래그먼트 화면 지정
    }

    // 프레그먼트 교체
    public void setFrag(int n)
    {
        fm = getSupportFragmentManager();
        ft= fm.beginTransaction();
        switch (n)
        {
            case 0:
                ft.replace(R.id.Main_Frame,frag1,"not");
                ft.commit();
                break;

            case 1:
                ft.replace(R.id.Main_Frame,frag2,"not");
                ft.commit();
                break;

            case 2:
                ft.replace(R.id.Main_Frame,frag3,"not");
                ft.commit();
                break;
            case 3:
                ft.replace(R.id.Main_Frame,frag4,"not");
                ft.commit();
                break;
            case 4:
                ft.replace(R.id.Main_Frame,frag5,"not");
                ft.commit();
                break;
            case 5:
                ft.replace(R.id.Main_Frame,frag6,"not");
                ft.commit();
                break;
            case 6:
                ft.replace(R.id.Main_Frame,frag7,"not");
                ft.commit();
                break;
            case 7:
                if(fm.findFragmentByTag("review")!=null){
                    Log.d("TedPark", "1");
                    frag8= (ReviewFragment) getSupportFragmentManager().findFragmentByTag("review");
                    ft.replace(R.id.Main_Frame,frag8,"review");
                }else{
                    Log.d("TedPark", "2");
                    frag8=new ReviewFragment();
                    ft.replace(R.id.Main_Frame,frag8,"review");
                }
                ft.commit();
                break;
            //여기가 리뷰
            case 8:
                ft.replace(R.id.Main_Frame,frag9,"not");
                ft.commit();
                break;
            case 9:
                ft.replace(R.id.Main_Frame,frag10,"not");
                ft.commit();
                break;
            case 10:
                ft.replace(R.id.Main_Frame,frag11,"not");
                ft.commit();
                break;
            case 11:
                ft.replace(R.id.Main_Frame,frag12,"not");
                ft.commit();
                break;
            case 12:
                ft.replace(R.id.Main_Frame,frag13,"not");
                ft.commit();
                break;
            case 13:
                ft.replace(R.id.Main_Frame,frag14,"not");
                ft.commit();
                break;
            case 14:
                ft.replace(R.id.Main_Frame,frag15,"not");
                ft.commit();
                break;
            case 15:
                ft.replace(R.id.Main_Frame,frag16,"not");
                ft.commit();
                break;
        }
    }

    public String getRealPathFromURI(Uri contentUri){
        if (contentUri.getPath().startsWith("/storage")) {
            return contentUri.getPath();
        }
        String id = DocumentsContract.getDocumentId(contentUri).split(":")[1];
        String[] columns = { MediaStore.Files.FileColumns.DATA };
        String selection = MediaStore.Files.FileColumns._ID + " = " + id;
        Cursor cursor = getContentResolver().query(MediaStore.Files.getContentUri("external"), columns, selection, null, null); try { int columnIndex = cursor.getColumnIndex(columns[0]);
            if (cursor.moveToFirst()) {
                return cursor.getString(columnIndex);
            }
        }
        finally {
            cursor.close();
        }
        return null;
    }

    public void resultfragmentChange() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        navController.navigate(R.id.action_nav_gallery_to_nav_result);
    }
    public void bagframeChange() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        navController.navigate(R.id.action_nav_result_to_nav_bag);
    }

    public void pass(String Kor){
        fm = getSupportFragmentManager();
        ft= fm.beginTransaction();

        Bundle bundle=new Bundle();
        //  bundle.putSerializable("json", response.body());

        bundle.putString("food",Kor);


        frag9.setArguments(bundle); //data being send to SecondFragment

        ft.replace(R.id.Main_Frame,frag9);
        ft.commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{ // toolbar의 back키 눌렀을 때 동작
//                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                transaction.replace(R.id.xx, R.id.Main_Frame, "not");
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.exit_to_right, R.anim.exit_to_right);
    }

    public ImageView getImgToolbar(){
         return this.img_toolbar;
    }
}