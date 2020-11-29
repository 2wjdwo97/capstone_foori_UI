package com.example.realkepstone.ui.mypage;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.realkepstone.FrontActivity;
import com.example.realkepstone.MainActivity;
import com.example.realkepstone.R;

import java.util.Locale;

public class LanguageFragment extends Fragment {

    CardView america;
    CardView france;
    ImageButton spain;
    CardView italy;
    CardView china;
    CardView taiwan;
    CardView japan;
    ImageButton vietnam;
    CardView germany;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_language, container, false);
        america=root.findViewById(R.id.America);
        france=root.findViewById(R.id.France);
        italy=root.findViewById(R.id.Italy);
        china=root.findViewById(R.id.China);
        japan=root.findViewById(R.id.Japan);
        germany=root.findViewById(R.id.German);





        america.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Locale eg = Locale.ENGLISH;
                Configuration config = new Configuration( );
                config.locale = eg;
                getResources( ).updateConfiguration( config, getResources( ).getDisplayMetrics( ) );

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


            }
        });
        china.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Locale asa = Locale.CHINA;
                Configuration config = new Configuration( );
                config.locale = asa;
                getResources( ).updateConfiguration( config, getResources( ).getDisplayMetrics( ) );


            }
        });

        japan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Locale jp = Locale.JAPAN;
                Configuration config = new Configuration( );
                config.locale = jp;
                getResources( ).updateConfiguration( config, getResources( ).getDisplayMetrics( ) );


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
            }
        });

        return root;
    }

}