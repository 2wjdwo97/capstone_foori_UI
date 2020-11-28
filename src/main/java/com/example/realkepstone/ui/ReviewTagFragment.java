package com.example.realkepstone.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.realkepstone.FrontActivity;
import com.example.realkepstone.MainActivity;
import com.example.realkepstone.R;
import com.example.realkepstone.SharedViewModel;
import com.example.realkepstone.data.Food;
import com.example.realkepstone.data.OrderData;
import com.example.realkepstone.data.ReviewSaveData;
import com.example.realkepstone.server.ApiInterface;
import com.example.realkepstone.server.HttpClient;
import com.example.realkepstone.server.JoinData;
import com.example.realkepstone.server.ReqLoginData;
import com.example.realkepstone.server.ResLoginData;
import com.example.realkepstone.ui.home.RightFragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReviewTagFragment extends Fragment {
    int user_no;
    private RatingBar ratingbar;
    ImageButton submit = null;
    private RatingBar spicybar;
    ApiInterface api;
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
    private SharedViewModel model;
    ArrayList<Integer> Tag = null;
    float spicy;
    float ratings;
    String foodName;
    ReviewSaveData reviewSaveData;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_reviewtag, container, false);
        submit = (ImageButton) root.findViewById(R.id.submit);
        model = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        user_no=model.getUser_no();
        Log.d("loginusedfdsfsdfrno", String.valueOf(user_no));
        EditText contents;
        api = HttpClient.getRetrofit().create( ApiInterface.class );

        contents = (EditText) root.findViewById(R.id.explain);
        Bundle bundle=getArguments();
        foodName = (String) getArguments().getString("food");

        Tag = new ArrayList<Integer>();
        ratingbar = root.findViewById(R.id.ratingBar);
        spicybar= root.findViewById(R.id.spicy);
        spicy=3;
        ratings=3;

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

        ratingbar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratings=ratingbar.getRating();
                Log.d("rating:", String.valueOf(rating));

            }
        });
        spicybar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                spicy = spicybar.getRating();
                Log.d("rating:", String.valueOf(rating));

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cont;
                cont = contents.getText().toString();

                reviewSaveData= new ReviewSaveData(user_no,foodName,ratings,spicy,cont,Tag);
                requestPost(reviewSaveData);


                Log.e("user_no", String.valueOf(user_no));
                Log.e("foodName", foodName);
                Log.e("ratings", String.valueOf(ratings));
                Log.e("spicy", String.valueOf(spicy));
                Log.e("cont", cont);
                Log.e("Tag", String.valueOf(Tag));


            }
        });



        return root;
    }

    public void requestPost(ReviewSaveData reviewSaveData) {

        Call<ReviewSaveData> call = api.requestReviewSave(reviewSaveData);

        // 비동기로 백그라운드 쓰레드로 동작
        call.enqueue(new Callback<ReviewSaveData>() {
            // 통신성공 후 텍스트뷰에 결과값 출력
            @Override
            public void onResponse(Call<ReviewSaveData> call, Response<ReviewSaveData> response) {
                if (response.code() == 200) {
                    Log.e("reviewsave", "성공");

                    ReviewFragment fragment = new ReviewFragment();
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.Main_Frame, fragment);
                    fragmentTransaction.commit();

                } else {
                    Toast.makeText(getContext().getApplicationContext(), R.string.error, Toast.LENGTH_LONG).show();
                    Log.e("reviewsave", String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<ReviewSaveData> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(), R.string.network, Toast.LENGTH_LONG).show();


            }
        });
    }

}
