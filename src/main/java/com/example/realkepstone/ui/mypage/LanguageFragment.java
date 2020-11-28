package com.example.realkepstone.ui.mypage;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.realkepstone.FrontActivity;
import com.example.realkepstone.MainActivity;
import com.example.realkepstone.R;

import java.util.Locale;

public class LanguageFragment extends Fragment {

    ImageButton america;
    ImageButton france;
    ImageButton spain;
    ImageButton italy;
    ImageButton china;
    ImageButton taiwan;
    ImageButton japan;
    ImageButton vietnam;
    ImageButton germany;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_language, container, false);
        america=root.findViewById(R.id.America);
        france=root.findViewById(R.id.France);
        spain=root.findViewById(R.id.Spain);
        italy=root.findViewById(R.id.italy);
        china=root.findViewById(R.id.china);
        taiwan=root.findViewById(R.id.taiwan);
        japan=root.findViewById(R.id.japan);
        vietnam=root.findViewById(R.id.vietnam);
        germany=root.findViewById(R.id.german);

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
        taiwan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Locale zh = Locale.TAIWAN;
                Configuration config = new Configuration( );
                config.locale = zh;
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
                Locale gem = Locale.GERMAN;
                Configuration config = new Configuration( );
                config.locale = gem;
                getResources( ).updateConfiguration( config, getResources( ).getDisplayMetrics( ) );

            }
        });

        return root;
    }

}