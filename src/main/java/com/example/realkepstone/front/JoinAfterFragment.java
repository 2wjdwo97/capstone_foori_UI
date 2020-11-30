package com.example.realkepstone.front;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.realkepstone.FrontActivity;
import com.example.realkepstone.MainActivity;
import com.example.realkepstone.MyPage_ReviewActivity;
import com.example.realkepstone.R;
import com.example.realkepstone.server.ApiInterface;
import com.example.realkepstone.server.FindIdData;
import com.example.realkepstone.server.HttpClient;
import com.example.realkepstone.server.TagData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JoinAfterFragment extends Fragment {
    ImageButton submit = null;
    ImageButton skip = null;

    ApiInterface api;
    Button class1 = null;
    Button class2 = null;
    Button class3 = null;
    Button class4 = null;
    Button class5 = null;
    Button class6 = null;
    Button class7 = null;
    Button class8 = null;
    Button class9 = null;
    Button class10 = null;
    Button class11 = null;
    Button class12 = null;
    Button class13 = null;
    Button class14 = null;
    Button class15 = null;
    Button class16 = null;
    Button class17 = null;
    Button class18 = null;
    Button class19 = null;
    Button class20 = null;
    Button class21 = null;
    Button class22 = null;
    Button class23 = null;
    Button class24 = null;
    Button class25 = null;
    Button class26= null;
    Button class27 = null;
    Button class28 = null;
    Button class29 = null;
    Button class30 = null;

    Button Tag1 = null;
    Button Tag2 = null;
    Button Tag3 = null;
    Button Tag4 = null;
    Button Tag5 = null;
    Button Tag6 = null;
    Button Tag7 = null;
    Button Tag8 = null;
    Button Tag9 = null;
    Button Tag10 = null;
    Button Tag11 = null;
    Button Tag12 = null;
    Button Tag13 = null;
    Button Tag14 = null;
    Button Tag15 = null;
    Button Tag16 = null;
    Button Tag17 = null;
    Button Tag18 = null;
    Button Tag19 = null;
    Button Tag20 = null;
    Button Tag21 = null;
    Button Tag22 = null;
    Button Tag23 = null;
    Button Tag24 = null;
    Button Tag25= null;
    Button Tag26 = null;
    Button Tag27 = null;
    Button Tag28 = null;
    Button Tag29 = null;
    Button Tag30 = null;
    Button Tag31 = null;
    Button Tag32 = null;

    ImageView allergy1 = null;
    ImageView allergy2 = null;
    ImageView allergy3 = null;
    ImageView allergy4 = null;
    ImageView allergy5 = null;
    ImageView allergy6 = null;
    ImageView allergy7 = null;
    ImageView allergy8 = null;
    ImageView allergy9 = null;
    ImageView allergy10 = null;
    ImageView allergy11 = null;
    ImageView allergy12 = null;
    ImageView allergy13 = null;
    ImageView allergy14 = null;
    ImageView allergy15 = null;
    ImageView allergy16 = null;
    ImageView allergy17 = null;


    ArrayList<Integer> foodClass = null;
    ArrayList<Integer> Tag = null;
    ArrayList<Integer> allergy = null;

    int user_no;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_joinafter, container, false);
        api = HttpClient.getRetrofit().create( ApiInterface.class );

        user_no=getArguments().getInt("user_no");

        foodClass = new ArrayList<Integer>();
        Tag = new ArrayList<Integer>();
        allergy = new ArrayList<Integer>();

        submit = (ImageButton) root.findViewById(R.id.submit);
        skip = (ImageButton) root.findViewById(R.id.skip);

        class1 = (Button) root.findViewById(R.id.class1);
        class2 = (Button) root.findViewById(R.id.class2);
        class3 = (Button) root.findViewById(R.id.class3);
        class4 = (Button) root.findViewById(R.id.class4);
        class5 = (Button) root.findViewById(R.id.class5);
        class6 = (Button) root.findViewById(R.id.class6);
        class7 = (Button) root.findViewById(R.id.class7);
        class8 = (Button) root.findViewById(R.id.class8);
        class9 = (Button) root.findViewById(R.id.class9);
        class10 = (Button) root.findViewById(R.id.class10);
        class11 = (Button) root.findViewById(R.id.class11);
        class12 = (Button) root.findViewById(R.id.class12);
        class13 = (Button) root.findViewById(R.id.class13);
        class14= (Button) root.findViewById(R.id.class14);
        class15 = (Button) root.findViewById(R.id.class15);
        class16 = (Button) root.findViewById(R.id.class16);
        class17 = (Button) root.findViewById(R.id.class17);
        class18 = (Button) root.findViewById(R.id.class18);
        class19 = (Button) root.findViewById(R.id.class19);
        class20 = (Button) root.findViewById(R.id.class20);
        class21 = (Button) root.findViewById(R.id.class21);
        class22 = (Button) root.findViewById(R.id.class22);
        class23 = (Button) root.findViewById(R.id.class23);
        class24 = (Button) root.findViewById(R.id.class24);
        class25= (Button) root.findViewById(R.id.class25);
        class26 = (Button) root.findViewById(R.id.class26);
        class27 = (Button) root.findViewById(R.id.class27);
        class28= (Button) root.findViewById(R.id.class28);
        class29= (Button) root.findViewById(R.id.class29);
        class30 = (Button) root.findViewById(R.id.class30);


        Tag1 = (Button) root.findViewById(R.id.tag1);
        Tag2 = (Button) root.findViewById(R.id.tag2);
        Tag3 = (Button) root.findViewById(R.id.tag3);
        Tag4 = (Button) root.findViewById(R.id.tag4);
        Tag5 = (Button) root.findViewById(R.id.tag5);
        Tag6 = (Button) root.findViewById(R.id.tag6);
        Tag7 = (Button) root.findViewById(R.id.tag7);
        Tag8 = (Button) root.findViewById(R.id.tag8);
        Tag9 = (Button) root.findViewById(R.id.tag9);
        Tag10 = (Button) root.findViewById(R.id.tag10);
        Tag11 = (Button) root.findViewById(R.id.tag11);
        Tag12 = (Button) root.findViewById(R.id.tag12);
        Tag13 = (Button) root.findViewById(R.id.tag13);
        Tag14 = (Button) root.findViewById(R.id.tag14);
        Tag15 = (Button) root.findViewById(R.id.tag15);
        Tag16 = (Button) root.findViewById(R.id.tag16);
        Tag17 = (Button) root.findViewById(R.id.tag17);
        Tag18 = (Button) root.findViewById(R.id.tag18);
        Tag19 = (Button) root.findViewById(R.id.tag19);
        Tag20 = (Button) root.findViewById(R.id.tag20);
        Tag21 = (Button) root.findViewById(R.id.tag21);
        Tag22 = (Button) root.findViewById(R.id.tag22);
        Tag23 = (Button) root.findViewById(R.id.tag23);
        Tag24 = (Button) root.findViewById(R.id.tag24);
        Tag25 = (Button) root.findViewById(R.id.tag25);
        Tag26 = (Button) root.findViewById(R.id.tag26);
        Tag27 = (Button) root.findViewById(R.id.tag27);
        Tag28 = (Button) root.findViewById(R.id.tag28);
        Tag29 = (Button) root.findViewById(R.id.tag29);
        Tag30 = (Button) root.findViewById(R.id.tag30);
        Tag31 = (Button) root.findViewById(R.id.tag31);
        Tag32 = (Button) root.findViewById(R.id.tag32);

        allergy1 = (ImageView) root.findViewById(R.id.allergy1);
        allergy2 = (ImageView) root.findViewById(R.id.allergy2);
        allergy3 = (ImageView) root.findViewById(R.id.allergy3);
        allergy4 = (ImageView) root.findViewById(R.id.allergy4);
        allergy5 = (ImageView) root.findViewById(R.id.allergy5);
        allergy6= (ImageView) root.findViewById(R.id.allergy6);
        allergy7 = (ImageView) root.findViewById(R.id.allergy7);
        allergy8 = (ImageView) root.findViewById(R.id.allergy8);
        allergy9 = (ImageView) root.findViewById(R.id.allergy9);
        allergy10 = (ImageView) root.findViewById(R.id.allergy10);
        allergy11 = (ImageView) root.findViewById(R.id.allergy11);
        allergy12 = (ImageView) root.findViewById(R.id.allergy12);
        allergy13 = (ImageView) root.findViewById(R.id.allergy13);
        allergy14 = (ImageView) root.findViewById(R.id.allergy14);
        allergy15 = (ImageView) root.findViewById(R.id.allergy15);
        allergy16 = (ImageView) root.findViewById(R.id.allergy16);
        allergy17 = (ImageView) root.findViewById(R.id.allergy17);




        allergy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    allergy.remove((Integer)1);
                    view.setSelected(false);
                }
                else{
                    allergy.add((Integer)1);
                    view.setSelected(true);
                }
            }
        });
        allergy2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    allergy.remove((Integer)2);
                    view.setSelected(false);
                }
                else{
                    allergy.add((Integer)2);
                    view.setSelected(true);
                }
            }
        });
        allergy3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    allergy.remove((Integer)3);
                    view.setSelected(false);
                }
                else{
                    allergy.add((Integer)3);
                    view.setSelected(true);
                }
            }
        });
        allergy4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    allergy.remove((Integer)4);
                    view.setSelected(false);
                }
                else{
                    allergy.add((Integer)4);
                    view.setSelected(true);
                }
            }
        });
        allergy5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    allergy.remove((Integer)5);
                    view.setSelected(false);
                }
                else{
                    allergy.add((Integer)5);
                    view.setSelected(true);
                }
            }
        });
        allergy6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    allergy.remove((Integer)6);
                    view.setSelected(false);
                }
                else{
                    allergy.add((Integer)6);
                    view.setSelected(true);
                }
            }
        });
        allergy7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    allergy.remove((Integer)7);
                    view.setSelected(false);
                }
                else{
                    allergy.add((Integer)7);
                    view.setSelected(true);
                }
            }
        });
        allergy8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    allergy.remove((Integer)8);
                    view.setSelected(false);
                }
                else{
                    allergy.add((Integer)8);
                    view.setSelected(true);
                }
            }
        });
        allergy9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    allergy.remove((Integer)9);
                    view.setSelected(false);
                }
                else{
                    allergy.add((Integer)9);
                    view.setSelected(true);
                }
            }
        });
        allergy10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    allergy.remove((Integer)10);
                    view.setSelected(false);
                }
                else{
                    allergy.add((Integer)10);
                    view.setSelected(true);
                }
            }
        });

        allergy11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    allergy.remove((Integer)11);
                    view.setSelected(false);
                }
                else{
                    allergy.add((Integer)11);
                    view.setSelected(true);
                }
            }
        });

        allergy12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    allergy.remove((Integer)12);
                    view.setSelected(false);
                }
                else{
                    allergy.add((Integer)12);
                    view.setSelected(true);
                }
            }
        });

        allergy13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    allergy.remove((Integer)13);
                    view.setSelected(false);
                }
                else{
                    allergy.add((Integer)13);
                    view.setSelected(true);
                }
            }
        });

        allergy14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    allergy.remove((Integer)15);
                    view.setSelected(false);
                }
                else{
                    allergy.add((Integer)15);
                    view.setSelected(true);
                }
            }
        });

        allergy15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    allergy.remove((Integer)16);
                    view.setSelected(false);
                }
                else{
                    allergy.add((Integer)16);
                    view.setSelected(true);
                }
            }
        });

        allergy16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    allergy.remove((Integer)17);
                    view.setSelected(false);
                }
                else{
                    allergy.add((Integer)17);
                    view.setSelected(true);
                }
            }
        });

        allergy17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    allergy.remove((Integer)18);
                    view.setSelected(false);
                }
                else{
                    allergy.add((Integer)18);
                    view.setSelected(true);
                }
            }
        });

        class1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    foodClass.remove((Integer)1);
                    view.setSelected(false);
                }
                else{
                    foodClass.add((Integer)1);
                    view.setSelected(true);
                }
            }
        });
        class2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    foodClass.remove((Integer)2);
                    view.setSelected(false);
                }
                else{
                    foodClass.add((Integer)2);
                    view.setSelected(true);
                }
            }
        });
        class3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    foodClass.remove((Integer)3);
                    view.setSelected(false);
                }
                else{
                    foodClass.add((Integer)3);
                    view.setSelected(true);
                }
            }
        });
        class4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    foodClass.remove((Integer)4);
                    view.setSelected(false);
                }
                else{
                    foodClass.add((Integer)4);
                    view.setSelected(true);
                }
            }
        });
        class5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    foodClass.remove((Integer)5);
                    view.setSelected(false);
                }
                else{
                    foodClass.add((Integer)5);
                    view.setSelected(true);
                }
            }
        });
        class6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    foodClass.remove((Integer)6);
                    view.setSelected(false);
                }
                else{
                    foodClass.add((Integer)6);
                    view.setSelected(true);
                }
            }
        });

        ////
        class7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    foodClass.remove((Integer)7);
                    view.setSelected(false);
                }
                else{
                    foodClass.add((Integer)7);
                    view.setSelected(true);
                }
            }
        });
        class8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    foodClass.remove((Integer)8);
                    view.setSelected(false);
                }
                else{
                    foodClass.add((Integer)8);
                    view.setSelected(true);
                }
            }
        });
        class9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    foodClass.remove((Integer)9);
                    view.setSelected(false);
                }
                else{
                    foodClass.add((Integer)9);
                    view.setSelected(true);
                }
            }
        });
        class10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    foodClass.remove((Integer)10);
                    view.setSelected(false);
                }
                else{
                    foodClass.add((Integer)10);
                    view.setSelected(true);
                }
            }
        });
        class11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    foodClass.remove((Integer)11);
                    view.setSelected(false);
                }
                else{
                    foodClass.add((Integer)11);
                    view.setSelected(true);
                }
            }
        });
        class12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    foodClass.remove((Integer)12);
                    view.setSelected(false);
                }
                else{
                    foodClass.add((Integer)12);
                    view.setSelected(true);
                }
            }
        });
        class13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    foodClass.remove((Integer)13);
                    view.setSelected(false);
                }
                else{
                    foodClass.add((Integer)13);
                    view.setSelected(true);
                }
            }
        });
        class14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    foodClass.remove((Integer)14);
                    view.setSelected(false);
                }
                else{
                    foodClass.add((Integer)14);
                    view.setSelected(true);
                }
            }
        });
        class15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    foodClass.remove((Integer)15);
                    view.setSelected(false);
                }
                else{
                    foodClass.add((Integer)15);
                    view.setSelected(true);
                }
            }
        });
        class16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    foodClass.remove((Integer)16);
                    view.setSelected(false);
                }
                else{
                    foodClass.add((Integer)16);
                    view.setSelected(true);
                }
            }
        });
        class17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    foodClass.remove((Integer)17);
                    view.setSelected(false);
                }
                else{
                    foodClass.add((Integer)17);
                    view.setSelected(true);
                }
            }
        });
        class18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    foodClass.remove((Integer)18);
                    view.setSelected(false);
                }
                else{
                    foodClass.add((Integer)18);
                    view.setSelected(true);
                }
            }
        });
        class19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    foodClass.remove((Integer)19);
                    view.setSelected(false);
                }
                else{
                    foodClass.add((Integer)19);
                    view.setSelected(true);
                }
            }
        });
        class20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    foodClass.remove((Integer)20);
                    view.setSelected(false);
                }
                else{
                    foodClass.add((Integer)20);
                    view.setSelected(true);
                }
            }
        });
        class21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    foodClass.remove((Integer)21);
                    view.setSelected(false);
                }
                else{
                    foodClass.add((Integer)21);
                    view.setSelected(true);
                }
            }
        });
        class22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    foodClass.remove((Integer)22);
                    view.setSelected(false);
                }
                else{
                    foodClass.add((Integer)22);
                    view.setSelected(true);
                }
            }
        });
        class23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    foodClass.remove((Integer)23);
                    view.setSelected(false);
                }
                else{
                    foodClass.add((Integer)23);
                    view.setSelected(true);
                }
            }
        });
        class24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    foodClass.remove((Integer)24);
                    view.setSelected(false);
                }
                else{
                    foodClass.add((Integer)24);
                    view.setSelected(true);
                }
            }
        });
        class25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    foodClass.remove((Integer)25);
                    view.setSelected(false);
                }
                else{
                    foodClass.add((Integer)25);
                    view.setSelected(true);
                }
            }
        });
        class26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    foodClass.remove((Integer)26);
                    view.setSelected(false);
                }
                else{
                    foodClass.add((Integer)26);
                    view.setSelected(true);
                }
            }
        });
        class27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    foodClass.remove((Integer)27);
                    view.setSelected(false);
                }
                else{
                    foodClass.add((Integer)27);
                    view.setSelected(true);
                }
            }
        });
        class28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    foodClass.remove((Integer)28);
                    view.setSelected(false);
                }
                else{
                    foodClass.add((Integer)28);
                    view.setSelected(true);
                }
            }
        });
        class29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    foodClass.remove((Integer)29);
                    view.setSelected(false);
                }
                else{
                    foodClass.add((Integer)29);
                    view.setSelected(true);
                }
            }
        });
        class30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    foodClass.remove((Integer)30);
                    view.setSelected(false);
                }
                else{
                    foodClass.add((Integer)30);
                    view.setSelected(true);
                }
            }
        });

        Tag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    Tag.remove((Integer)1);
                    view.setSelected(false);
                }
                else{
                    Tag.add((Integer)1);
                    view.setSelected(true);
                }
            }
        });
        Tag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    Tag.remove((Integer)2);
                    view.setSelected(false);
                }
                else{
                    Tag.add((Integer)2);
                    view.setSelected(true);
                }
            }
        });
        Tag3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    Tag.remove((Integer)3);
                    view.setSelected(false);
                }
                else{
                    Tag.add((Integer)3);
                    view.setSelected(true);
                }
            }
        });
        Tag4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    Tag.remove((Integer)4);
                    view.setSelected(false);
                }
                else{
                    Tag.add((Integer)4);
                    view.setSelected(true);
                }
            }
        });
        Tag5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    Tag.remove((Integer)5);
                    view.setSelected(false);
                }
                else{
                    Tag.add((Integer)5);
                    view.setSelected(true);
                }
            }
        });
        Tag6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    Tag.remove((Integer)6);
                    view.setSelected(false);
                }
                else{
                    Tag.add((Integer)6);
                    view.setSelected(true);
                }
            }
        });
        Tag7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    Tag.remove((Integer)7);
                    view.setSelected(false);
                }
                else{
                    Tag.add((Integer)7);
                    view.setSelected(true);
                }
            }
        });
        Tag8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    Tag.remove((Integer)8);
                    view.setSelected(false);
                }
                else{
                    Tag.add((Integer)8);
                    view.setSelected(true);
                }
            }
        });
        Tag9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    Tag.remove((Integer)9);
                    view.setSelected(false);
                }
                else{
                    Tag.add((Integer)9);
                    view.setSelected(true);
                }
            }
        });
        Tag10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    Tag.remove((Integer)10);
                    view.setSelected(false);
                }
                else{
                    Tag.add((Integer)10);
                    view.setSelected(true);
                }
            }
        });
        Tag11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    Tag.remove((Integer)11);
                    view.setSelected(false);
                }
                else{
                    Tag.add((Integer)11);
                    view.setSelected(true);
                }
            }
        });
        Tag12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    Tag.remove((Integer)12);
                    view.setSelected(false);
                }
                else{
                    Tag.add((Integer)12);
                    view.setSelected(true);
                }
            }
        });
        Tag13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    Tag.remove((Integer)13);
                    view.setSelected(false);
                }
                else{
                    Tag.add((Integer)13);
                    view.setSelected(true);
                }
            }
        });
        Tag14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    Tag.remove((Integer)14);
                    view.setSelected(false);
                }
                else{
                    Tag.add((Integer)14);
                    view.setSelected(true);
                }
            }
        });
        Tag15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    Tag.remove((Integer)15);
                    view.setSelected(false);
                }
                else{
                    Tag.add((Integer)15);
                    view.setSelected(true);
                }
            }
        });
        Tag16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    Tag.remove((Integer)16);
                    view.setSelected(false);
                }
                else{
                    Tag.add((Integer)16);
                    view.setSelected(true);
                }
            }
        });
        Tag17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    Tag.remove((Integer)17);
                    view.setSelected(false);
                }
                else{
                    Tag.add((Integer)17);
                    view.setSelected(true);
                }
            }
        });
        Tag18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    Tag.remove((Integer)18);
                    view.setSelected(false);
                }
                else{
                    Tag.add((Integer)18);
                    view.setSelected(true);
                }
            }
        });
        Tag19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    Tag.remove((Integer)19);
                    view.setSelected(false);
                }
                else{
                    Tag.add((Integer)19);
                    view.setSelected(true);
                }
            }
        });
        Tag20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    Tag.remove((Integer)20);
                    view.setSelected(false);
                }
                else{
                    Tag.add((Integer)20);
                    view.setSelected(true);
                }
            }
        });
        Tag21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    Tag.remove((Integer)21);
                    view.setSelected(false);
                }
                else{
                    Tag.add((Integer)21);
                    view.setSelected(true);
                }
            }
        });
        Tag22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    Tag.remove((Integer)22);
                    view.setSelected(false);
                }
                else{
                    Tag.add((Integer)22);
                    view.setSelected(true);
                }
            }
        });
        Tag23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    Tag.remove((Integer)23);
                    view.setSelected(false);
                }
                else{
                    Tag.add((Integer)23);
                    view.setSelected(true);
                }
            }
        });
        Tag24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    Tag.remove((Integer)24);
                    view.setSelected(false);
                }
                else{
                    Tag.add((Integer)24);
                    view.setSelected(true);
                }
            }
        });
        Tag25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    Tag.remove((Integer)25);
                    view.setSelected(false);
                }
                else{
                    Tag.add((Integer)25);
                    view.setSelected(true);
                }
            }
        });
        Tag26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    Tag.remove((Integer)26);
                    view.setSelected(false);
                }
                else{
                    Tag.add((Integer)26);
                    view.setSelected(true);
                }
            }
        });
        Tag27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    Tag.remove((Integer)27);
                    view.setSelected(false);
                }
                else{
                    Tag.add((Integer)27);
                    view.setSelected(true);
                }
            }
        });
        Tag28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    Tag.remove((Integer)28);
                    view.setSelected(false);
                }
                else{
                    Tag.add((Integer)28);
                    view.setSelected(true);
                }
            }
        });
        Tag29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    Tag.remove((Integer)29);
                    view.setSelected(false);
                }
                else{
                    Tag.add((Integer)29);
                    view.setSelected(true);
                }
            }
        });
        Tag30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    Tag.remove((Integer)30);
                    view.setSelected(false);
                }
                else{
                    Tag.add((Integer)30);
                    view.setSelected(true);
                }
            }
        });
        Tag31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    Tag.remove((Integer)31);
                    view.setSelected(false);
                }
                else{
                    Tag.add((Integer)31);
                    view.setSelected(true);
                }
            }
        });

        Tag32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isSelected()){
                    Tag.remove((Integer)32);
                    view.setSelected(false);
                }
                else{
                    Tag.add((Integer)32);
                    view.setSelected(true);
                }
            }
        });



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                requestPost(user_no, foodClass, Tag, allergy);
                Log.d("user_no", String.valueOf(user_no));

                Log.d("TedPark", String.valueOf(foodClass));
                Log.d("TedPark", String.valueOf(Tag));
                Log.d("TedPark", String.valueOf(allergy));



            }

        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtra("user_no",user_no);
                startActivity(intent);
            }
        });






        return root;
    }


    public void requestPost(int userNo, List<Integer> foodClassNo, List<Integer> tagNo, List<Integer> allergyNo) {
        TagData tagData = new TagData(userNo, foodClassNo, tagNo, allergyNo);
        Call<TagData> call = api.requestTag( tagData );

/*
- 저장 성공: JsonResponse({"message": "TASTE_SAVED"}, status=200)
 */
        call.enqueue( new Callback<TagData>() {
            @Override
            public void onResponse(Call<TagData> call, Response<TagData> response) {
                if(response.code()==200){
                    ((FrontActivity) getActivity()).joinafterfragmentChange();

                    Toast.makeText(getContext().getApplicationContext(), getResources().getString(R.string.success), Toast.LENGTH_LONG).show();


                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    intent.putExtra("user_no",user_no);

                    startActivity(intent);


                }
                else{
                    Toast.makeText(getContext().getApplicationContext(), getResources().getString(R.string.network), Toast.LENGTH_LONG).show();
                    Log.d("TedPark", String.valueOf(response.code()));
                    Log.d("Message", "code..."+userNo);
                    Log.d("Message", "foodclass..."+foodClassNo);
                    Log.d("Message", "tag..."+ tagNo);
                    Log.d("Message", "allergy"+allergyNo);




                }
            }

            @Override
            public void onFailure(Call<TagData> call, Throwable t) {
                Log.d("TedPark", "실패"+String.valueOf(t));
                Toast.makeText(getContext().getApplicationContext(), getResources().getString(R.string.network), Toast.LENGTH_LONG).show();
            }
        } );
    }


}