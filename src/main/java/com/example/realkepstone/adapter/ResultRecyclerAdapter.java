package com.example.realkepstone.adapter;
//
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
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
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.realkepstone.MainActivity;
import com.example.realkepstone.R;
import com.example.realkepstone.SharedViewModel;
import com.example.realkepstone.adapter.RecyclerAdapter;
import com.example.realkepstone.data.Food;
import com.example.realkepstone.data.FoodAfter;
import com.example.realkepstone.ui.BagFragment;
import com.example.realkepstone.ui.ResultFragment;

import java.util.ArrayList;

public class ResultRecyclerAdapter extends RecyclerView.Adapter<ResultRecyclerAdapter.ItemViewHolder> {

    // adapter에 들어갈 list 입니다.
    public ArrayList<Food> listData = new ArrayList<>();
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_foodafter, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        // Item을 하나, 하나 보여주는(bind 되는) 함수입니다.
        holder.onBind(listData.get(position), position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
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

    // RecyclerView의 핵심인 ViewHolder 입니다.
    // 여기서 subView를 setting 해줍니다.
    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView order;
        private TextView textView1;
        private TextView textView2;
        private TextView star;
        private ImageView imageView1;
        private Food data;
        private int position;
        private TextView allergy;
        private RelativeLayout linear;
        private LinearLayout linearItem2;
        private TextView content;
        private ImageView medal;
        private RelativeLayout relative;

        CardView less;
        CardView more;
        TextView prnumber;

        ItemViewHolder(View itemView) {
            super(itemView);

            order = itemView.findViewById(R.id.order);
            textView1 = itemView.findViewById(R.id.Title);
            textView2 = itemView.findViewById(R.id.Kor);
            imageView1 = itemView.findViewById(R.id.imageView1);
            star = itemView.findViewById(R.id.starpoint);
            linear=itemView.findViewById(R.id.Linear);
            relative=itemView.findViewById(R.id.relative);
            content = itemView.findViewById(R.id.content);
            allergy = itemView.findViewById(R.id.Allergy);
            medal = itemView.findViewById(R.id.medal);
            linearItem2 = itemView.findViewById(R.id.linearItem2);
            more=itemView.findViewById(R.id.more);
            less=itemView.findViewById(R.id.less);
            prnumber=itemView.findViewById(R.id.prnumber);
        }

        void onBind(Food data, int position) {
            this.data = data;
            this.position = position;

            textView1.setText(data.getEng());
            textView2.setText(data.getKor());
            content.setText(data.getDes());

            prnumber.setText(String.valueOf(data.getAmount()));

            star.setText(String.valueOf(data.getStar()));

            allergy.setText(String.valueOf(data.getAllergy()));
            // star.setText(data.get());
//            textView1.setText(data.getEng());
            if(data.getRecommed()==1){
                medal.setImageResource(R.drawable.button_gold);
            }else if(data.getRecommed()==2){
                medal.setImageResource(R.drawable.button_silver);
            }else if(data.getRecommed()==3){
                medal.setImageResource(R.drawable.button_cop);
            }else{
                Log.e("image", String.valueOf(data.getRecommed()));
            }


            Glide
                    .with(imageView1.getContext())
                    .load(data.getUrl())
                    .centerCrop()
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(imageView1);
            Log.e("url",data.getUrl());

            changeVisibility(selectedItems.get(position));

            itemView.setOnClickListener(this);
            linearItem2.setOnClickListener(this);
            textView1.setOnClickListener(this);
            textView2.setOnClickListener(this);
            //    imageView1.setOnClickListener(this);
            order.setOnClickListener(this);
            less.setOnClickListener(this);
            more.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.linearItem2:
                    if (selectedItems.get(position)) {
                        // 펼쳐진 Item을 클릭 시
                        changeColor();
                        selectedItems.delete(position);
                    } else {
                        changeColor();
                        // 직전의 클릭됐던 Item의 클릭상태를 지움
                        selectedItems.delete(prePosition);
                        // 클릭한 Item의 position을 저장
                        selectedItems.put(position, true);
                    }
                    notifyItemChanged(position);

                    // 해당 포지션의 변화를 알림
                    if (prePosition != -1) notifyItemChanged(prePosition);
                    notifyItemChanged(position);
                    // 클릭된 position 저장
                    prePosition = position;
                    break;
                case R.id.less:
                    if(data.getAmount()>0){
                        data.setAmount(data.getAmount()-1);
                    }
                    prnumber.setText(String.valueOf(data.getAmount()));
                    Log.d("ddddfdsf", String.valueOf(data.getAmount()));
                    break;
                case R.id.more:
                    data.setAmount(data.getAmount()+1);
                    prnumber.setText(String.valueOf(data.getAmount()));
                    break;
                case R.id.order:
                    if (data.getAmount()>0){
                        data.setSelect(true);
                        changeColor();
                        Log.d("TedPark", data.getKor()+"이게 노랑");
                    }
                    else {
                        data.setSelect(false);
                        Log.d("TedPark", data.getKor()+"이게 파랑");
                        changeColor();
                    }
                    break;
            }
        }
        /**
         * 클릭된 Item의 상태 변경
         * @paramisExpandedItem을 펼칠 것인지 여부
         */
        private void changeColor(){
            if (data.isSelect()==true){
                linear.setBackgroundColor(Color.parseColor("#FFE08C"));
                relative.setBackgroundColor(Color.parseColor("#FFE08C"));
            }
            else {
                linear.setBackgroundColor(Color.parseColor("#F2F2F2"));
                relative.setBackgroundColor(Color.WHITE);
            }
        }

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
                    linear.getLayoutParams().height = value;
                    linear.requestLayout();
                    // imageView가 실제로 사라지게하는 부분
                    linear.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
                }
            });
            // Animation start
            va.start();
        }
    }
}