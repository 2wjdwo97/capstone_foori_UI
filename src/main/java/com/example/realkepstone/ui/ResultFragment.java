package com.example.realkepstone.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.realkepstone.FrontActivity;
import com.example.realkepstone.MainActivity;
import com.example.realkepstone.R;
import com.example.realkepstone.SharedViewModel;
import com.example.realkepstone.adapter.ResultRecyclerAdapter;
import com.example.realkepstone.data.Food;
import com.example.realkepstone.data.FoodAfter;
import com.example.realkepstone.front.JoinAfterFragment;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResultFragment extends Fragment {

    private RecyclerView recyclerView;
    private ImageView bag;
    private TextView id;
    private ResultRecyclerAdapter adapter;
    Context contex;
    TextView textView;
    private SharedViewModel model;

    private int someStateValue;
    private final String SOME_VALUE_KEY = "someValueToSave";

    // Fires when a configuration change occurs and fragment needs to save state
    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.d("TedPark", "저장하는 곳은 옴");
        outState.putSerializable("backup", adapter.listData);
        Log.d("TedPark", adapter.listData.get(0).getKor()+"이름 이거임");

        super.onSaveInstanceState(outState);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_result, container, false);
        FoodAfter foodAfter = null;
        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerView2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new ResultRecyclerAdapter();
        recyclerView.setAdapter(adapter);
        id = (TextView) rootView.findViewById(R.id.id);
        ArrayList<Food> data = new ArrayList<>();
        ArrayList<Food> OrderList = new ArrayList<>();
        ArrayList<Food> OrderBack = new ArrayList<>();


        Log.d("TedPark", "json 받아오기");
        Bundle bundle=getArguments();
        if (bundle!=null) {
            Log.d("TedPark", "json 받음");
            if(bundle.containsKey("json")) {
                foodAfter = (FoodAfter) getArguments().getSerializable("json");
                getData(foodAfter);
            }
            else{
                data = (ArrayList<Food>) getArguments().getSerializable("data");
                adapter.listData=data;
                OrderBack = (ArrayList<Food>) getArguments().getSerializable("trash");
                for(int i=0; i<data.size(); i++){
                    for(int j=0; j<OrderBack.size(); j++){
                        if(data.get(i).getKor()==OrderBack.get(j).getKor()){
                            data.get(i).setSelect(false);
                            Log.d("TedPark", OrderBack.get(j).isSelect()+"뭐가지워졌냐");

                        }
                    }

                }
            }
        }
        else{
            Log.d("TedPark", "근데 받을게 없음");
        }


/*        bag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int passSize;
                Log.e("result", String.valueOf(OrderList.size()));
                passSize=passData(OrderList);

                MainActivity activity = (MainActivity) getActivity();

                FragmentTransaction transaction=getActivity().getSupportFragmentManager().beginTransaction();
                BagFragment mfragment=new BagFragment();

                Bundle bundle=new Bundle();
                //  bundle.putSerializable("json", response.body());

                bundle.putSerializable("bag", OrderList);
                bundle.putInt("bagsize", passSize);
                bundle.putSerializable("data", adapter.listData);


                mfragment.setArguments(bundle); //data being send to SecondFragment
                transaction.replace(R.id.Main_Frame, mfragment,"not");
                transaction.commit();
            }
        });*/
        return rootView;
    }
    private void getData(FoodAfter foodAfter) {

        int number=foodAfter.getFoodKorName().size();

        Log.d("TedPark", String.valueOf(number));

        List <String> listKor = new ArrayList<String>();
        List <String> listEng = new ArrayList<String>();
        List <Float> listSpicy = new ArrayList<Float>();
        List <String> listIngre = new ArrayList<String>();
        List <String> listDes = new ArrayList<String>();
        List <String> listAller = new ArrayList<String>();
        List <String> listUrl = new ArrayList<String>();
        List <String> listTag = new ArrayList<String>();
        List <Integer> listRecommend = new ArrayList<Integer>();
        List <Float> listStar =new ArrayList<Float>();

        for(int i=0; i<number; i++){
            listKor.add(foodAfter.getFoodKorName().get(i));
            listEng.add(foodAfter.getFoodEngName().get(i));
            listSpicy.add(foodAfter.getSpicy().get(i));
            listIngre.add(foodAfter.getFoodIngredients().get(i).toString());
            listDes.add(foodAfter.getFoodDescription().get(i));
            listAller.add(foodAfter.getFoodAllergy().get(i).toString());
            listUrl.add(foodAfter.getFoodImgUrl().get(i));
            listTag.add(foodAfter.getFood_tags().get(i).toString());
            listRecommend.add(foodAfter.getRecommendFood().get(i));
            listStar.add(foodAfter.getStar().get(i));
        }

        for (int i = 0; i < number; i++) {
            // 각 List의 값들을 data 객체에 set 해줍니다.
            Food food = new Food();
            food.setKor(listKor.get(i));
            food.setEng(listEng.get(i));
            food.setDes(listDes.get(i));
            food.setUrl(listUrl.get(i));
            food.setRecommed(listRecommend.get(i));
            food.setSpicy(listSpicy.get(i));
            food.setTag(listTag.get(i));
            food.setAllergy(listAller.get(i));
            food.setStar(listStar.get(i));
            // 각 값이 들어간 data를 adapter에 추가합니다.
            adapter.addItem(food);
        }

        // adapter의 값이 변경되었다는 것을 알려줍니다.
        adapter.notifyDataSetChanged();
    }

    private int passData(ArrayList<Food> OrderList){
        int getSize = adapter.listData.size();
        int passSize=0;
        List <String> listKor = new ArrayList<String>();
        List <String> listEng = new ArrayList<String>();
        List <String> listIngre = new ArrayList<String>();
        List <String> listDes = new ArrayList<String>();
        List <String> listAller = new ArrayList<String>();
        List <String> listUrl = new ArrayList<String>();
        List <Float> listStar = new ArrayList<Float>();

        for(int i=0; i<getSize; i++){
            if(adapter.listData.get(i).isSelect()){
                passSize++;
                listKor.add(adapter.listData.get(i).getKor());
                listEng.add(adapter.listData.get(i).getEng());
                listDes.add(adapter.listData.get(i).getDes());
                listUrl.add(adapter.listData.get(i).getUrl());
                listStar.add(adapter.listData.get(i).getStar());
            }
        }

        for (int i = 0; i < passSize; i++) {
            // 각 List의 값들을 data 객체에 set 해줍니다.
            Food food = new Food();
            food.setKor(listKor.get(i));
            food.setEng(listEng.get(i));
            food.setDes(listDes.get(i));
            food.setUrl(listUrl.get(i));
            food.setStar(listStar.get(i));

            // 각 값이 들어간 data를 adapter에 추가합니다.
            OrderList.add(food);
        }

        return passSize;
    }

}