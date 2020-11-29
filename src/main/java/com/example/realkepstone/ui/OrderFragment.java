package com.example.realkepstone.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.realkepstone.R;
import com.example.realkepstone.SharedViewModel;
import com.example.realkepstone.data.Food;
import com.example.realkepstone.data.OrderData;
import com.example.realkepstone.data.RevReqData;
import com.example.realkepstone.data.RevResData;
import com.example.realkepstone.server.ApiInterface;
import com.example.realkepstone.server.HttpClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderFragment extends Fragment {

    ArrayList<Food> OrderList;
    ArrayList<String> FoodName;
    ApiInterface api;
    int user_no;
    private SharedViewModel model;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_order, container, false);
        api = HttpClient.getRetrofit().create( ApiInterface.class );
        model = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        user_no=model.getUser_no();
        Log.d("fdg", String.valueOf(user_no));

        FoodName=new ArrayList<String>();

        Bundle bundle=getArguments();
        OrderList = (ArrayList<Food>) getArguments().getSerializable("bag");

        for(int i=0; i<OrderList.size(); i++){
            FoodName.add(OrderList.get(i).getKor());
        }
        Log.d("fdg", String.valueOf(FoodName.size()));
        Log.d("fdg", String.valueOf(user_no));
        Log.d("fdg", FoodName.get(0));


        requestPost(user_no, FoodName);

        return root;

    }
    public void requestPost(int user_no, List<String> foodName) {
        OrderData orderData = new OrderData(user_no, foodName);
        Call<OrderData> call = api.requestOrder(orderData);

        // 비동기로 백그라운드 쓰레드로 동작
        call.enqueue(new Callback<OrderData>() {
            // 통신성공 후 텍스트뷰에 결과값 출력
            @Override
            public void onResponse(Call<OrderData> call, Response<OrderData> response) {
                if (response.code() == 200) {
                } else {
                    Toast.makeText(getContext().getApplicationContext(), getResources().getString(R.string.success), Toast.LENGTH_LONG).show();
                    Log.e("order", String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<OrderData> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(), getResources().getString(R.string.network), Toast.LENGTH_LONG).show();


            }
        });
    }


}