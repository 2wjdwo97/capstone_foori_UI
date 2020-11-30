package com.example.realkepstone.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.realkepstone.FoodListActivity;
import com.example.realkepstone.MainActivity;
import com.example.realkepstone.R;
import com.example.realkepstone.SharedViewModel;
import com.example.realkepstone.adapter.RecyclerAdapter;
import com.example.realkepstone.data.Food;
import com.example.realkepstone.data.TodayData;
import com.example.realkepstone.data.TodayReqData;
import com.example.realkepstone.server.ApiInterface;
import com.example.realkepstone.server.HttpClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private MainActivity activity;
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private ArrayList<Food> list = new ArrayList<>();

    int user_no;
    private SharedViewModel model;
    private ImageView h1;
    private ImageView h2;
    private ImageView h3;
    private ImageView h4;
    private ImageView h5;
    private ImageView h6;
    private ImageView h7;
    private ImageView h8;
    private ImageView h9;
    private ImageView h10;
    ApiInterface api;

    private ImageView hidden;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_home, container, false);
        activity = (MainActivity) getActivity();

        api = HttpClient.getRetrofit().create( ApiInterface.class );
        model = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        user_no = model.getUser_no();
        Log.d("log_user_no", String.valueOf(user_no));

        h1 = (ImageView) rootView.findViewById(R.id.button__rice);
        h2 = (ImageView) rootView.findViewById(R.id.button_soup);
        h3 = (ImageView) rootView.findViewById(R.id.button_noodle);
        h4 = (ImageView) rootView.findViewById(R.id.button_stir_fried);
        h5 = (ImageView) rootView.findViewById(R.id.button_fried);
        h6 = (ImageView) rootView.findViewById(R.id.button_grilled);
        h7 = (ImageView) rootView.findViewById(R.id.button_bread);
        h8 = (ImageView) rootView.findViewById(R.id.button_boiled_in_seasoning);
        h9 = (ImageView) rootView.findViewById(R.id.button_steamed);
        h10 = (ImageView) rootView.findViewById(R.id.button_baverage);

        hidden = (ImageView) rootView.findViewById(R.id.hidden);

        h1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change("Rice", 1);
            }
        });
        h2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change("Soup", 2);
            }
        });
        h3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change("Noodle", 3);
            }
        });
        h4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { change("Stir-Fried", 4); }
        });
        h5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change("Fried", 5);
            }
        });
        h6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change("Grilled", 6);
            }
        });
        h7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change("Bread", 7);
            }
        });
        h8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change("Boiled in Seasoning", 8);
            }
        });
        h9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change("Steamed", 9);
            }
        });
        h10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change("Beverage", 10);
            }
        });

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        adapter = new RecyclerAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        hidden.setVisibility(View.VISIBLE);


        Animation a = AnimationUtils.loadAnimation(getContext(), R.anim.progress_anim);
        a.setDuration(1000);
        hidden.startAnimation(a);


        requestPost(user_no);

        return rootView;
    }

    public void change(String title, int button_no) {
        Intent intent = new Intent((MainActivity) getActivity(), FoodListActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        bundle.putInt("user_no", user_no);
        bundle.putInt("button_no", button_no);
        intent.putExtra("json", bundle);
        startActivity(intent);
        activity.overridePendingTransition(R.anim.enter_from_right, R.anim.enter_from_right);
    }


    public void requestPost(int user_no) {
        TodayReqData todayReqData = new TodayReqData(user_no);

        Call<List<TodayData>> call = api.requestToday(todayReqData);

        // 비동기로 백그라운드 쓰레드로 동작
        call.enqueue( new Callback<List<TodayData>>() {
            // 통신성공 후 텍스트뷰에 결과값 출력
            @Override
            public void onResponse(Call<List<TodayData>> call, Response<List<TodayData>> response) {
                if(response.code()==200){


                    if(response.body().size()==0){
                        Log.e("loginusedfdsfsdfrno", "sex");
                        hidden.setBackgroundResource(R.drawable.no_data);
                        hidden.clearAnimation();
                    }else{
                        Log.e("loginusedfdsfsdfrno", "sex!E@!RAFA");
                        hidden.clearAnimation();

                        hidden.setVisibility(View.GONE);
                    }



                    for(int i=0; i<response.body().size(); i++){
                        hidden.setVisibility(View.GONE);

                        adapter.addItem(response.body().get(i));
                        adapter.notifyDataSetChanged();
                    }
                }
                else{
                    Log.e("homeerror", String.valueOf(response.code()));
//                    Toast.makeText(getContext().getApplicationContext(), getResources().getString(R.string.incorrect), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<TodayData>> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(), getResources().getString(R.string.network), Toast.LENGTH_LONG).show();
            }
        } );
    }
}