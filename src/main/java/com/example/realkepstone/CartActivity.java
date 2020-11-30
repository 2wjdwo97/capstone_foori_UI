package com.example.realkepstone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.example.realkepstone.adapter.BagAdapter;
import com.example.realkepstone.data.Food;
import com.example.realkepstone.ui.OrderFragment;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    private ArrayList<Food> data;
    private ArrayList<Food> OrderList;

    private ImageButton order = null;
    private BagAdapter adapter;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tb_cart);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Cart");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mHandler = new Handler();
        adapter = new BagAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        RecyclerView recyclerView = findViewById(R.id.recycler_cart);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        order = (ImageButton) findViewById(R.id.btn_cart_order);

        Intent intent = getIntent();
        OrderList = null;
        OrderList = (ArrayList<Food>) intent.getSerializableExtra("bag");
        data = (ArrayList<Food>) intent.getSerializableExtra("data");

        if (OrderList != null) ;
        Log.e("orderlist", String.valueOf(OrderList.size()));
        getData(OrderList);

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mHandler.postDelayed(new Runnable() {
                    public void run() {
                        //  createNotification();
                    }
                }, 5000); // 0.5초후

                getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                OrderFragment mfragment = new OrderFragment();

                Bundle bundle = new Bundle();
                bundle.putSerializable("bag", OrderList);
                mfragment.setArguments(bundle); //data being send to SecondFragment
                transaction.replace(R.id.frame_cart, mfragment);
                transaction.commit();
            }
        });
    }

    private void getData(ArrayList<Food> OrderList) {
        // 임의의 데이터입니다.
        List<String> listKor = new ArrayList<String>();
        List<String> listEng = new ArrayList<String>();
        List<String> listUrl = new ArrayList<>();
        List<String> listDes = new ArrayList<>();
        List<Integer> listAmount = new ArrayList<>();

        int size = OrderList.size();

        for (int i = 0; i < size; i++) {

            listKor.add(OrderList.get(i).getKor());
            listEng.add(OrderList.get(i).getEng());
            listDes.add(OrderList.get(i).getDes());
            listAmount.add(OrderList.get(i).getAmount());
            listUrl.add(OrderList.get(i).getUrl());

        }
        for (int i = 0; i < size; i++) {
            // 각 List의 값들을 data 객체에 set 해줍니다.
            Food food = new Food();
            food.setKor(listKor.get(i));
            food.setEng(listEng.get(i));
            food.setUrl(listUrl.get(i));
            food.setDes(listDes.get(i));
            food.setAmount(listAmount.get(i));

            food.setSelect(true);
            // 각 값이 들어간 data를 adapter에 추가합니다.
            adapter.addItem(food);
        }

        // adapter의 값이 변경되었다는 것을 알려줍니다.
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                Log.e("whaat","1111");

                finish();
                Log.e("whaat","fcfds");


                Intent intent = new Intent(this, MenuRecogActivity.class);

                intent.putExtra("data", data);
                intent.putExtra("trash", adapter.trash);

                startActivity(intent);
                overridePendingTransition(R.anim.enter_from_right, R.anim.enter_from_right);



                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}