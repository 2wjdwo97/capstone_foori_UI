package com.example.realkepstone.ui.mypage;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.realkepstone.FoodListActivity;
import com.example.realkepstone.MainActivity;
import com.example.realkepstone.MyPage_DeleteActivity;
import com.example.realkepstone.MyPage_LanguageActivity;
import com.example.realkepstone.MyPage_PasswordActivity;
import com.example.realkepstone.MyPage_PreferenceActivity;
import com.example.realkepstone.MyPage_ReviewActivity;
import com.example.realkepstone.R;
import com.example.realkepstone.ui.ResultFragment;

public class MypageFragment extends Fragment {


    private MainActivity activity;
    TextView review;
    TextView quit;
    TextView pwchange;
    TextView changepref;
    TextView language;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_mypage, container, false);
        activity = (MainActivity) getActivity();
        review=root.findViewById(R.id.review);
        pwchange=root.findViewById(R.id.pwchange);
        changepref=root.findViewById(R.id.tagchange);
        quit=root.findViewById(R.id.quit);
        language=root.findViewById(R.id.language);

        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change("review");
            }
        });
        language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change("language");
            }
        });
        pwchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change("password");
            }
        });
        changepref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change("preference");
            }
        });
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change("delete");
            }
        });
        return root;
    }
    public void change(String title) {
        Intent intent = new Intent();

        switch(title){
            case "review":
                intent = new Intent((MainActivity) getActivity(), MyPage_ReviewActivity.class);
                break;
            case "language":
                intent = new Intent((MainActivity) getActivity(), MyPage_LanguageActivity.class);
                break;
            case "preference":
                intent = new Intent((MainActivity) getActivity(), MyPage_PreferenceActivity.class);
                break;
            case "password":
                intent = new Intent((MainActivity) getActivity(), MyPage_PasswordActivity.class);
                break;
            case "delete":
                intent = new Intent((MainActivity) getActivity(), MyPage_DeleteActivity.class);
                break;
            default:
                break;
        }
        startActivity(intent);
        activity.overridePendingTransition(R.anim.enter_from_right, R.anim.enter_from_right);
    }
}