package com.example.realkepstone.ui;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.realkepstone.FrontActivity;
import com.example.realkepstone.MainActivity;
import com.example.realkepstone.R;
import com.example.realkepstone.adapter.BagAdapter;
import com.example.realkepstone.adapter.ResultRecyclerAdapter;
import com.example.realkepstone.data.Food;
import com.example.realkepstone.data.FoodAfter;
import com.example.realkepstone.front.JoinAfterFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class BagFragment extends Fragment {


    ImageButton order = null;
    ImageButton back = null;
    private RecyclerView recyclerView;
    private BagAdapter adapter;
    Context contex;
    TextView textView;
    ArrayList<Food> data;
    ArrayList<Food> OrderList;
    Handler mHandler;
    ArrayList<Food> BackList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_bag, container, false);

        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerView3);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        back = (ImageButton) rootView.findViewById(R.id.back);
        order = (ImageButton) rootView.findViewById(R.id.order);
        mHandler = new Handler();

        adapter = new BagAdapter();
        recyclerView.setAdapter(adapter);

        List<String> listKor = new ArrayList<String>();
        List<String> listEng = new ArrayList<String>();

        Bundle bundle=getArguments();
        OrderList = (ArrayList<Food>) getArguments().getSerializable("bag");
        int bagSize= getArguments().getInt("bagSize");
        data = (ArrayList<Food>) getArguments().getSerializable("data");

        Log.e("orderlist", String.valueOf(OrderList.size()));

        getData(OrderList);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity activity = (MainActivity) getActivity();

                FragmentTransaction transaction=getActivity().getSupportFragmentManager().beginTransaction();
                ResultFragment mfragment=new ResultFragment();

                Bundle bundle=new Bundle();
                //  bundle.putSerializable("json", response.body());

                bundle.putSerializable("data", data);
                bundle.putSerializable("trash", adapter.trash);

                mfragment.setArguments(bundle); //data being send to SecondFragment
                transaction.replace(R.id.Main_Frame, mfragment,"not");
                transaction.commit();

            }
        });
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mHandler.postDelayed(new Runnable()  {
                    public void run() {
                      //  createNotification();
                    }
                }, 5000); // 0.5초후

                MainActivity activity = (MainActivity) getActivity();

                FragmentTransaction transaction=getActivity().getSupportFragmentManager().beginTransaction();
                OrderFragment mfragment=new OrderFragment();

                Bundle bundle=new Bundle();
                //  bundle.putSerializable("json", response.body());
                bundle.putSerializable("bag", adapter.listData);
                mfragment.setArguments(bundle); //data being send to SecondFragment
                transaction.replace(R.id.Main_Frame, mfragment);
                transaction.commit();

            }
        });
        return rootView;
    }

    private void getData(ArrayList<Food> OrderList) {
    // 임의의 데이터입니다.
        List <String> listKor = new ArrayList<String>();
        List <String> listEng = new ArrayList<String>();
        List <String> listUrl = new ArrayList<>();
        List <String> listDes = new ArrayList<>();
        List <Integer> listAmount = new ArrayList<>();

        int size=OrderList.size();

        for(int i=0; i<size; i++){
            if(listAmount.get(i)>0) {
                listKor.add(OrderList.get(i).getKor());
                listEng.add(OrderList.get(i).getEng());
                listDes.add(OrderList.get(i).getDes());
                listAmount.add(OrderList.get(i).getAmount());
                listUrl.add(OrderList.get(i).getUrl());
            }
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

    private void createNotification() {

        Intent intent = new Intent(getContext().getApplicationContext(),FrontActivity.class);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(getActivity(), "default");
        PendingIntent pendnoti = PendingIntent.getActivity(getContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);


        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("How was your dinner?");
        builder.setContentText("We need your preference~");
        builder.setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE);
        builder.setWhen(Calendar.getInstance().getTimeInMillis()+60000);

        builder.setColor(Color.RED);
        // 사용자가 탭을 클릭하면 자동 제거
        builder.setAutoCancel(true);

        // 알림 표시
        NotificationManager notificationManager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager.createNotificationChannel(new NotificationChannel("default", "기본 채널", NotificationManager.IMPORTANCE_DEFAULT));
        }

        // id값은
        // 정의해야하는 각 알림의 고유한 int값
        notificationManager.notify(1, builder.build());


    }
    private void removeNotification() {
        // Notification 제거
        NotificationManagerCompat.from(getActivity()).cancel(1);
    }
}
