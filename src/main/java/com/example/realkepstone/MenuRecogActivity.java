package com.example.realkepstone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.realkepstone.adapter.ResultRecyclerAdapter;
import com.example.realkepstone.data.Food;
import com.example.realkepstone.data.FoodAfter;

import java.util.ArrayList;
import java.util.List;

public class MenuRecogActivity extends AppCompatActivity {

//    ArrayList<Food> data = new ArrayList<>();
//    ArrayList<Food> OrderBack = new ArrayList<>();
    ArrayList<Food> OrderList;

    private ImageView bag;
    private TextView id;
    private RecyclerView recyclerView;
    private ResultRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_recog);

        Intent intent = getIntent();

        OrderList = new ArrayList<>();

        FoodAfter foodAfter = null;
        ArrayList<Food> data = new ArrayList<>();
        ArrayList<Food> OrderBack = new ArrayList<>();




        Toolbar toolbar = (Toolbar)findViewById(R.id.tb_menu_recog);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Result");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.recycler_menu_recog);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new ResultRecyclerAdapter();
        recyclerView.setAdapter(adapter);

        if(intent.getExtras().containsKey("json")) {
            foodAfter = (FoodAfter) intent.getSerializableExtra("json");
            getData(foodAfter);
            Log.d("TedPark", "뭐가지워졌fasdfdsafasdf냐");

        }
        else
        {
            data = (ArrayList<Food>) intent.getSerializableExtra("data");
            adapter.listData=data;
            OrderBack = (ArrayList<Food>) intent.getSerializableExtra("trash");

            Log.d("adsgsdfads", String.valueOf(OrderBack.size()));

            for(int i=0; i<data.size(); i++) {
                for (int j = 0; j < OrderBack.size(); j++) {
                    if (adapter.listData.get(i).getKor().equals( OrderBack.get(j).getKor())) {
                        adapter.listData.get(i).setSelect(false);
                        adapter.listData.get(i).setAmount(OrderBack.get(j).getAmount());
                        Log.d("TedPark", OrderBack.get(j).isSelect() + "뭐가지워졌냐");
                    }
                }
            }
        }
    }

    // Fires when a configuration change occurs and fragment needs to save state
    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.d("TedPark", "저장하는 곳은 옴");
        outState.putSerializable("backup", adapter.listData);
        Log.d("TedPark", adapter.listData.get(0).getKor() + "이름 이거임");

        super.onSaveInstanceState(outState);
    }

    private void getData(FoodAfter foodAfter) {

        int number = foodAfter.getFoodKorName().size();

        Log.d("TedPark", String.valueOf(number));

        List<String> listKor = new ArrayList<String>();
        List<String> listEng = new ArrayList<String>();
        List<Float> listSpicy = new ArrayList<Float>();
        List<String> listIngre = new ArrayList<String>();
        List<String> listDes = new ArrayList<String>();
        List<String> listAller = new ArrayList<String>();
        List<String> listUrl = new ArrayList<String>();
        List<String> listTag = new ArrayList<String>();
        List<Integer> listRecommend = new ArrayList<Integer>();
        List<Float> listStar = new ArrayList<Float>();

        for (int i = 0; i < number; i++) {
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

    private int passData(ArrayList<Food> OrderList) {
        int getSize = adapter.listData.size();
        int passSize = 0;
        List<String> listKor = new ArrayList<String>();
        List<String> listEng = new ArrayList<String>();
        List<String> listIngre = new ArrayList<String>();
        List<String> listDes = new ArrayList<String>();
        List<String> listAller = new ArrayList<String>();
        List<String> listUrl = new ArrayList<String>();
        List<Float> listStar = new ArrayList<Float>();
        List<Integer> listAmount= new ArrayList<>();

        for (int i = 0; i < getSize; i++) {
            if (adapter.listData.get(i).getAmount()>0) {
                passSize++;
                listKor.add(adapter.listData.get(i).getKor());
                listEng.add(adapter.listData.get(i).getEng());
                listDes.add(adapter.listData.get(i).getDes());
                listUrl.add(adapter.listData.get(i).getUrl());
                listStar.add(adapter.listData.get(i).getStar());
                listAmount.add(adapter.listData.get(i).getAmount());

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
            food.setAmount(listAmount.get(i));

            // 각 값이 들어간 data를 adapter에 추가합니다.
            OrderList.add(food);
        }

        return passSize;
    }

    // Toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.btn_cart, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            // 뒤로가기 버튼
            case android.R.id.home:{
                finish();
                overridePendingTransition(R.anim.exit_to_right, R.anim.exit_to_right);
                return true;
            }
            // 장바구니 버튼
            case R.id.btn_bag:{
                int passSize;
                passSize=passData(OrderList);

                finish();
                Intent intent = new Intent(this, CartActivity.class);

                intent.putExtra("bag", OrderList);
                intent.putExtra("data", adapter.listData);
                startActivity(intent);
                overridePendingTransition(R.anim.enter_from_right, R.anim.enter_from_right);

                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}