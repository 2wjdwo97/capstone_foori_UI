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

public class BagAdapter extends RecyclerView.Adapter<BagAdapter.ItemViewHolder> {

    // adapter에 들어갈 list 입니다.
    public ArrayList<Food> listData = new ArrayList<>();
    public ArrayList<Food> trash = new ArrayList<>();
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart, parent, false);
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
    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView txt_Amount;

        private TextView txt_delete;
        private TextView txt_engName;
        private TextView txt_korName;
        private Food data;
        private int position;

        ItemViewHolder(View itemView) {
            super(itemView);

            txt_delete = itemView.findViewById(R.id.txt_Amount);

            txt_delete = itemView.findViewById(R.id.txt_delete);
            txt_engName = itemView.findViewById(R.id.txt_engName);
            txt_korName = itemView.findViewById(R.id.txt_korName);
        }

        void onBind(Food data, int position) {
            this.data = data;
            this.position = position;

            txt_engName.setText(data.getEng());
            txt_korName.setText(data.getKor());

            txt_Amount.setText(data.getAmount());

/*            Glide
                    .with(img_food.getContext())
                    .load(data.getUrl())
                    .centerCrop()
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(img_food);
*/
            //changeVisibility(selectedItems.get(position));

            itemView.setOnClickListener(this);
            txt_delete.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {

                case R.id.txt_delete:
                    trash.add(data);
                    deleteItem(data);
                    selectedItems.delete(position);
                    if (prePosition != -1) notifyItemChanged(prePosition);
                    // 클릭된 position 저장
                    prePosition = position;
                    notifyItemRemoved(getAdapterPosition());
                    notifyItemChanged(position);

                    break;
            }
        }


 /*       *//**
         * 클릭된 Item의 상태 변경
         * @param isExpanded Item을 펼칠 것인지 여부
         *//*
        private void changeVisibility(final boolean isExpanded) {
            // height 값을 dp로 지정해서 넣고싶으면 아래 소스를 이용
            int dpValue = 105;
            float d = context.getResources().getDisplayMetrics().density;
            int height = (int) (dpValue * d);

            // ValueAnimator.ofInt(int... values)는 View가 변할 값을 지정, 인자는 int 배열
            ValueAnimator va = isExpanded ? ValueAnimator.ofInt(0, height) : ValueAnimator.ofInt(height, 0);
            // Animation이 실행되는 시간, n/1000초
            va.setDuration(100);
            va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    // value는 height 값
                    int value = (int) animation.getAnimatedValue();
                    // imageView의 높이 변경
                    layout_cart.getLayoutParams().height = value;
                    layout_cart.requestLayout();
                    // imageView가 실제로 사라지게하는 부분
                    layout_cart.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
                }
            });
            // Animation start
            va.start();
        }*/
    }
}