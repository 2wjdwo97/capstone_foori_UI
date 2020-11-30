package com.example.realkepstone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.realkepstone.ui.home.HighestFragment;
import com.example.realkepstone.ui.home.MostFragment;
import com.example.realkepstone.ui.home.RightFragment;

public class FoodListActivity extends AppCompatActivity {

    private int button_no;
    private int user_no;
    private String tb_title;
    private Button most;
    private Button highest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_rightview);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("json");
        assert bundle != null;

        tb_title = bundle.getString("title");
        user_no = bundle.getInt("user_no");
        button_no = bundle.getInt("button_no");

        getSupportActionBar().setTitle(tb_title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        highest = findViewById(R.id.highest);
        most = findViewById(R.id.most);

        highest.setOnClickListener(view -> {

            if (!view.isSelected()) {
                Log.d("FoodListActivity_highest", "clicked");
                view.setSelected(true);
                most.setSelected(false);

                HighestFragment fragment = new HighestFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

                Bundle bd_highest = new Bundle();
                bd_highest.putInt("user_no", user_no);
                bd_highest.putInt("button_no", button_no);
                fragment.setArguments(bd_highest);

                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_right);
                fragmentTransaction.replace(R.id.subFrame, fragment);
                fragmentTransaction.commit();

                Log.d("FoodListActivity_highest", "clicked_end");
            }
        });

        most.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!view.isSelected()) {
                    Log.d("FoodListActivity_most", "clicked_start");
                    view.setSelected(true);
                    highest.setSelected(false);

                    MostFragment fragment = new MostFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

                    Bundle bd_most = new Bundle();
                    bd_most.putInt("user_no", user_no);
                    bd_most.putInt("button_no", button_no);
                    fragment.setArguments(bd_most);

                    fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_right);
                    fragmentTransaction.replace(R.id.subFrame, fragment);
                    fragmentTransaction.commit();
                    Log.d("FoodListActivity_most", "clicked_end");
                }

            }
        });

        highest.callOnClick();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.exit_to_right, R.anim.exit_to_right);
    }
}