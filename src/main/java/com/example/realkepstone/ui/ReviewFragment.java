package com.example.realkepstone.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.realkepstone.FrontActivity;
import com.example.realkepstone.MainActivity;
import com.example.realkepstone.R;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.realkepstone.SharedViewModel;
import com.example.realkepstone.adapter.ReviewAdapter;
import com.example.realkepstone.data.Food;
import com.example.realkepstone.data.RevReqData;
import com.example.realkepstone.data.RevResData;
import com.example.realkepstone.server.ApiInterface;
import com.example.realkepstone.server.HttpClient;
import com.example.realkepstone.server.ReqLoginData;
import com.example.realkepstone.server.ResLoginData;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class    ReviewFragment extends Fragment {


    ImageButton review = null;
    ImageButton back = null;
    private RecyclerView recyclerView;
    private ReviewAdapter adapter;
    Context contex;
    TextView textView;
    ArrayList<Food> OrderList;
    ApiInterface api;
    int user_no;
    private SharedViewModel model;
    ArrayList<String> Kor;
    ArrayList<String> Url;
    ArrayList<String> Eng;

    ImageView hidden;
    TextView txt_hidden;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_review, container, false);
        model = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        user_no=model.getUser_no();
        Log.d("loginusedfdsfsdfrno", String.valueOf(user_no));
        Kor= new ArrayList<String>();
        Eng= new ArrayList<String>();
        Url= new ArrayList<String>();
        hidden = (ImageView) rootView.findViewById(R.id.hidden);
        txt_hidden = (TextView) rootView.findViewById(R.id.txt_hidden);
        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerView3);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),3);
        recyclerView.setLayoutManager(gridLayoutManager);


        api = HttpClient.getRetrofit().create( ApiInterface.class );

        adapter = new ReviewAdapter();
        recyclerView.setAdapter(adapter);
        hidden.setVisibility(View.VISIBLE);

        Animation a = AnimationUtils.loadAnimation(getContext(), R.anim.progress_anim);
        a.setDuration(1000);
        hidden.startAnimation(a);

        requestPost(user_no);


        return rootView;
    }

    public void requestPost(int user_no) {
        RevReqData revReqData = new RevReqData(user_no);
        Call<List<RevResData>> call = api.requestRevReq( revReqData );

        // 비동기로 백그라운드 쓰레드로 동작
        call.enqueue( new Callback<List<RevResData>>() {
            // 통신성공 후 텍스트뷰에 결과값 출력
            @Override
            public void onResponse(Call<List<RevResData>> call, Response<List<RevResData>> response) {
                if(response.code()==200){
                    Log.e("loginusedfdsfsdfrno", String.valueOf(response.code()));

                    if(response.body().size()==0){
                        hidden.clearAnimation();
                        hidden.getLayoutParams().height = 166;
                        hidden.getLayoutParams().width = 100;
                        hidden.setBackgroundResource(R.drawable.no_data);
                        txt_hidden.setVisibility(View.VISIBLE);
                    }else{
                        Log.e("review_frag", "size>0");
                        hidden.clearAnimation();

                        hidden.setVisibility(View.GONE);
                    }

                    for(int i = 0; i<response.body().size(); i++) {
                        Kor.add(response.body().get(i).getFoodName());
                        Eng.add(response.body().get(i).getTranslatedName());
                        Url.add(response.body().get(i).getFoodImgUrl());
                    }
                    getData(Kor);

                }
                else{
                    Log.e("review_frag_not200", String.valueOf(user_no));
                    Log.e("review_frag_not200",String.valueOf(response.code()));
                    Toast.makeText(getContext().getApplicationContext(), getResources().getString(R.string.error), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<RevResData>> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(), getResources().getString(R.string.network), Toast.LENGTH_LONG).show();


            }
        } );
    }

    private void getData(ArrayList<String> Kor) {
        // 임의의 데이터입니다.

        List <String> listKor = new ArrayList<String>();
        List <String> listEng = new ArrayList<String>();
        List <String> listUrl = new ArrayList<String>();
        hidden.setVisibility(View.GONE);

        int size=Kor.size();

        if(size==0){
            hidden.setVisibility(View.VISIBLE);

        }


        for(int i=0; i<size; i++){
            listKor.add(Kor.get(i));
            //   listEng.add(Eng.get(i));
            listUrl.add(Url.get(i));
            listEng.add(Eng.get(i));

        }
        for (int i = 0; i < size; i++) {
            // 각 List의 값들을 data 객체에 set 해줍니다.
            Food food = new Food();
            food.setKor(listKor.get(i));
            // food.setEng(listEng.get(i));
            food.setUrl(listUrl.get(i));
            food.setSelect(true);
            // 각 값이 들어간 data를 adapter에 추가합니다.
            adapter.addItem(food);
        }

        // adapter의 값이 변경되었다는 것을 알려줍니다.
        adapter.notifyDataSetChanged();
    }




}