package com.example.realkepstone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.realkepstone.FrontActivity;
import com.example.realkepstone.MainActivity;
import com.example.realkepstone.R;
import com.example.realkepstone.SharedViewModel;
import com.example.realkepstone.data.LanguageData;
import com.example.realkepstone.server.ApiInterface;
import com.example.realkepstone.server.HttpClient;
import com.example.realkepstone.server.ReqLoginData;

import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyPage_LanguageActivity extends AppCompatActivity {

    CardView america;
    CardView france;
    ImageButton spain;
    CardView italy;
    CardView china;
    CardView taiwan;
    CardView japan;
    ImageButton vietnam;
    CardView germany;
    String lang;
    ApiInterface api;
    int user_no;
    private SharedViewModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page__language);

        Intent intent = getIntent();

        Toolbar toolbar = (Toolbar)findViewById(R.id.tb_language);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("My Language");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        america=findViewById(R.id.America);
        france=findViewById(R.id.France);
        italy=findViewById(R.id.Italy);
        china=findViewById(R.id.China);
        japan=findViewById(R.id.Japan);
        germany=findViewById(R.id.German);

        model = new ViewModelProvider(this).get(SharedViewModel.class);
        user_no=model.getUser_no();
        Log.d("loginusedfdsfsdfrno", String.valueOf(user_no));
        api = HttpClient.getRetrofit().create( ApiInterface.class );



        america.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Locale eg = Locale.ENGLISH;
                Configuration config = new Configuration( );
                config.locale = eg;
                getResources( ).updateConfiguration( config, getResources( ).getDisplayMetrics( ) );
                lang="en";
                requestPost(lang,user_no);
            }
        });

        france.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Locale fr = Locale.FRANCE;
// 환경설정 가져오기
                Configuration config = new Configuration( );
// 환경설정 값에서 지역설정을 영어로 변경
                config.locale = fr;
// 리소스를 변경된 지역설정을 기준으로 갱신하기
                getResources( ).updateConfiguration( config, getResources( ).getDisplayMetrics( ) );
                lang="fr";
                requestPost(lang,user_no);

                //    invalidateViews();
            }
        });
// 로케일을 영어로 설정


        italy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Locale it = Locale.ITALIAN;
                Configuration config = new Configuration( );
                config.locale = it;
                getResources( ).updateConfiguration( config, getResources( ).getDisplayMetrics( ) );

                lang="it";
                requestPost(lang,user_no);

            }
        });
        china.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Locale asa = Locale.CHINA;
                Configuration config = new Configuration( );
                config.locale = asa;
                getResources( ).updateConfiguration( config, getResources( ).getDisplayMetrics( ) );

                lang="zh-cn";
                requestPost(lang,user_no);

            }
        });

        japan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Locale jp = Locale.JAPAN;
                Configuration config = new Configuration( );
                config.locale = jp;
                getResources( ).updateConfiguration( config, getResources( ).getDisplayMetrics( ) );

                lang="ja";
                requestPost(lang,user_no);

            }
        });
        germany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Locale de = Locale.GERMAN;
                Configuration config = new Configuration( );
                config.locale = de;
                getResources( ).updateConfiguration( config, getResources( ).getDisplayMetrics( ) );
                Log.e("language","German");
                lang="de";
                requestPost(lang,user_no);

            }
        });
    }
    public void requestPost(String lang, int user_no) {
        LanguageData languageData = new LanguageData(user_no,lang);
        Call<LanguageData> call = api.requestLang( languageData );

        // 비동기로 백그라운드 쓰레드로 동작
        call.enqueue( new Callback<LanguageData>() {
            // 통신성공 후 텍스트뷰에 결과값 출력
            @Override
            public void onResponse(Call<LanguageData> call, Response<LanguageData> response) {
                if(response.code()==200) {
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.success), Toast.LENGTH_LONG).show();
                }
                else{
                    Log.e("quit", String.valueOf(response.code()));

                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.error), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LanguageData> call, Throwable t) {
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.network), Toast.LENGTH_LONG).show();

            }
        } );
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            // 뒤로가기 버튼
            case android.R.id.home:{
                finish();
                overridePendingTransition(R.anim.exit_to_right, R.anim.exit_to_right);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}