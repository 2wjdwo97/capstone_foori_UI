package com.example.realkepstone;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.viewpager.widget.ViewPager;

import com.example.realkepstone.data.FoodAfter;
import com.example.realkepstone.ui.BagFragment;
import com.example.realkepstone.ui.OrderFragment;
import com.example.realkepstone.ui.ResultFragment;
import com.example.realkepstone.ui.ReviewFragment;
import com.example.realkepstone.ui.ReviewTagFragment;
import com.example.realkepstone.ui.gallery.GalleryFragment;
import com.example.realkepstone.ui.mypage.ChangePWFragment;
import com.example.realkepstone.ui.mypage.ChangeTagFragment;
import com.example.realkepstone.ui.mypage.LanguageFragment;
import com.example.realkepstone.ui.mypage.QuitFragment;
import com.example.realkepstone.ui.mypage.ReviewsFragment;
import com.example.realkepstone.ui.slideshow.SlideshowFragment;
import com.example.realkepstone.ui.home.HomeFragment;
import com.example.realkepstone.ui.mypage.MypageFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {



    private AppBarConfiguration mAppBarConfiguration;
    private BottomNavigationView bottomNavigationView; // 바텀 네비게이션 뷰
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
    Bundle mBundle; //main bundle
    private ViewPager viewPager;
    MenuItem previousMenuItem;
    FoodAfter foodafter;
    int user_no;

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

        SharedViewModel model = new ViewModelProvider(this).get(SharedViewModel.class);

        model.setUser_no(user_no);
        Log.d("세팅", String.valueOf(model.getUser_no()));


        FoodAfter foodafter = new FoodAfter();

        if (savedInstanceState != null) {
            //Restore the fragment's instance
            frag5 = (ResultFragment) getSupportFragmentManager().getFragment(savedInstanceState, "Result");
        }





        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        bottomNavigationView = findViewById(R.id.bottomNavi);

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



        /*
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.camera:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.gallery:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.mypage:
                        viewPager.setCurrentItem(3);
                        break;
                    case R.id.review:
                        viewPager.setCurrentItem(4);
                        break;
                }
                return true;
            }

        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    bottomNavigationView.setSelectedItemId(R.id.home);
                } else if (position == 1) {
                    bottomNavigationView.setSelectedItemId(R.id.camera);
                } else if (position == 2) {
                    bottomNavigationView.setSelectedItemId(R.id.gallery);
                }else if (position == 3) {
                    bottomNavigationView.setSelectedItemId(R.id.mypage);
                }
                else if (position == 4) {
                    bottomNavigationView.setSelectedItemId(R.id.review);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

*/

        bottomNavigationView.setOnNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId())
            {
                case R.id.home:
                    setFrag(0);
                    break;
                case R.id.camera:
                    setFrag(1);
                    break;
                case R.id.mypage :
                    setFrag(3);
                    break;
                case R.id.gallery:
                    setFrag(2);
                    break;
                case R.id.review:
                    setFrag(7);
                    break;
            }
            return true;
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

}