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
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.realkepstone.FoodListActivity;
import com.example.realkepstone.MainActivity;
import com.example.realkepstone.MyPage_DeleteActivity;
import com.example.realkepstone.MyPage_LanguageActivity;
import com.example.realkepstone.MyPage_PasswordActivity;
import com.example.realkepstone.MyPage_PreferenceActivity;
import com.example.realkepstone.MyPage_ReviewActivity;
import com.example.realkepstone.R;
import com.example.realkepstone.SharedViewModel;
import com.example.realkepstone.ui.ResultFragment;

public class MypageFragment extends Fragment {

    private SharedViewModel model;
    private MainActivity activity;
    private int user_no;
    TextView review;
    TextView quit;
    TextView pwchange;
    TextView changepref;
    TextView language;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_mypage, container, false);

        review=root.findViewById(R.id.review);
        pwchange=root.findViewById(R.id.pwchange);
        changepref=root.findViewById(R.id.tagchange);
        quit=root.findViewById(R.id.quit);
        language=root.findViewById(R.id.language);

        model = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        user_no = model.getUser_no();

        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change("review", user_no);
            }
        });
        language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change("language", user_no);
            }
        });
        pwchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change("password", user_no);
            }
        });
        changepref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change("preference", user_no);
            }
        });
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change("delete", user_no);
            }
        });
        return root;
    }
    public void change(String title, int user_no) {
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
        intent.putExtra("user_no", user_no);
        startActivity(intent);
        activity.overridePendingTransition(R.anim.enter_from_right, R.anim.enter_from_right);
    }
}