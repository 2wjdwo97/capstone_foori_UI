package com.example.realkepstone.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.realkepstone.R;
import com.example.realkepstone.data.HomeData;

import java.util.ArrayList;
import java.util.List;

public class HighestAdapter extends RecyclerView.Adapter<HighestAdapter.ItemViewHolder> {

    // adapter에 들어갈 list 입니다.
    private ArrayList<HomeData> listData = new ArrayList<>();
    Context context;
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // LayoutInflater를 이용하여 전 단계에서 만들었던 item.xml을 inflate 시킵니다.
        // return 인자는 ViewHolder 입니다.
        context=parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
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

    public void addItem(HomeData data) {
        // 외부에서 item을 추가시킬 함수입니다.
        listData.add(data);
    }

    // RecyclerView의 핵심인 ViewHolder 입니다.
    // 여기서 subView를 setting 해줍니다.
    class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView Title;
        private TextView star;
        private TextView content;
        private TextView tag;
        private TextView KorName;
        private TextView alllergy;
        private ImageView imageView;

        ItemViewHolder(View itemView) {
            super(itemView);

            Title = itemView.findViewById(R.id.Title);
            KorName = itemView.findViewById(R.id.korName);
            star = itemView.findViewById(R.id.starpoint);
            content = itemView.findViewById(R.id.content);
            tag = itemView.findViewById(R.id.tag);
            alllergy = itemView.findViewById(R.id.Allergy);
            imageView = itemView.findViewById(R.id.imageView1);
        }

        void onBind(HomeData data) {
            Title.setText(data.getTranslated_name());
            KorName.setText(data.getFoodName());
            content.setText(data.getFoodDsc());
            star.setText(String.valueOf(data.getFoodStar()));
            tag.setText(String.valueOf(data.getTag()));

            alllergy.setText(String.valueOf(data.getAllergy()));

            content.setText(data.getFoodDsc());
            Glide
                    .with(imageView.getContext())
                    .load(data.getFoodImgUrl())
                    .centerCrop()
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(imageView);

        }
    }



}