package com.example.realkepstone.adapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.realkepstone.R;
import com.example.realkepstone.data.Food;
import com.example.realkepstone.data.TodayData;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder> {

    // adapter에 들어갈 list 입니다.
    private ArrayList<TodayData> listData = new ArrayList<>();

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // LayoutInflater를 이용하여 전 단계에서 만들었던 item.xml을 inflate 시킵니다.
        // return 인자는 ViewHolder 입니다.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item2, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        // Item을 하나, 하나 보여주는(bind 되는) 함수입니다.
        holder.onBind(listData.get(position));
    }

    @Override
    public int getItemCount() {
        // RecyclerView의 총 개수 입니다.
        return listData.size();
    }

    public void addItem(TodayData food) {
        // 외부에서 item을 추가시킬 함수입니다.
        listData.add(food);
    }

    // RecyclerView의 핵심인 ViewHolder 입니다.
    // 여기서 subView를 setting 해줍니다.
    class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView textView1;
        private TextView textView2;
        private TextView textView_Desc;
        private ImageView imageView;

        ItemViewHolder(View itemView) {
            super(itemView);

            textView1 = itemView.findViewById(R.id.Kor);
            textView2 = itemView.findViewById(R.id.Eng);
            textView_Desc = itemView.findViewById(R.id.Desc);
            imageView = itemView.findViewById(R.id.imageView);
        }

        void onBind(TodayData food) {
            textView1.setText(food.getFoodName());
            textView2.setText(food.getTranslatedName());
            textView_Desc.setText(food.getFoodDsc());
            Glide
                    .with(imageView.getContext())
                    .load(food.getFoodImgUrl())
                    .centerCrop()
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(imageView);
        }
    }
}