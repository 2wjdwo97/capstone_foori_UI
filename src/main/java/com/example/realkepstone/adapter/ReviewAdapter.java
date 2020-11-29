package com.example.realkepstone.adapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.realkepstone.MainActivity;
import com.example.realkepstone.R;
import com.example.realkepstone.adapter.RecyclerAdapter;
import com.example.realkepstone.data.Food;
import com.example.realkepstone.data.FoodAfter;

import java.util.ArrayList;
//
public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ItemViewHolder> {

    // adapter에 들어갈 list 입니다.
    private ArrayList<Food> listData = new ArrayList<>();
    private Context context;
    // Item의 클릭 상태를 저장할 array 객체
    private SparseBooleanArray selectedItems = new SparseBooleanArray();
    // 직전에 클릭됐던 Item의 position
    private int prePosition = -1;

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // LayoutInflater를 이용하여 전 단계에서 만들었던 item.xml을 inflate 시킵니다.
        // return 인자는 ViewHolder 입니다.
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_review, parent, false);


        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        // Item을 하나, 하나 보여주는(bind 되는) 함수입니다.
        holder.onBind(listData.get(position), position);
    }

    @Override
    public int getItemCount() {
        // RecyclerView의 총 개수 입니다.
        return listData.size();
    }

    public void addItem(Food data) {
        // 외부에서 item을 추가시킬 함수입니다.
        listData.add(data);
    }
    public void deleteItem(Food data) {
        // 외부에서 item을 추가시킬 함수입니다.
        listData.remove(data);
    }

    // RecyclerView의 핵심인 ViewHolder 입니다.
    // 여기서 subView를 setting 해줍니다.
    class ItemViewHolder extends RecyclerView.ViewHolder{

        private ImageButton order;
        private TextView eng;
        private TextView korea;
        private ImageView imageView1;
        private ImageView food;
        private Food data;
        private int position;

        ItemViewHolder(View itemView) {
            super(itemView);

            order = itemView.findViewById(R.id.order);
            korea = itemView.findViewById(R.id.korea);
            eng = itemView.findViewById(R.id.eng);
            food = itemView.findViewById(R.id.food);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    deleteItem(data);
                    MainActivity activity = (MainActivity) context;
                    Log.d("1111111111111111111111111111111111111111111111111", "1");
                    Log.d("1111111111111111111111111111111111111111111111111", (String) korea.getText());

                    activity.pass((String) korea.getText());
                }
            });

        }

        void onBind(Food data, int position) {
            this.data = data;
            this.position = position;
            korea.setText(data.getKor());
            eng.setText(data.getEng());
            Glide
                    .with(food.getContext())
                    .load(data.getUrl())
                    .centerCrop()
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(food);
            Log.e("urlsex",data.getUrl());
        }
    }
}