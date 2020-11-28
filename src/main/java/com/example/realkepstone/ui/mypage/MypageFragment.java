package com.example.realkepstone.ui.mypage;

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

import com.example.realkepstone.MainActivity;
import com.example.realkepstone.R;
import com.example.realkepstone.ui.ResultFragment;

public class MypageFragment extends Fragment {

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

        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity activity = (MainActivity) getActivity();
                activity.setFrag(12);
            }
        });
        language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity activity = (MainActivity) getActivity();
                activity.setFrag(13);
            }
        });
        pwchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity activity = (MainActivity) getActivity();
                activity.setFrag(9);
            }
        });
        changepref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity activity = (MainActivity) getActivity();
                activity.setFrag(10);
            }
        });
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity activity = (MainActivity) getActivity();
                activity.setFrag(11);
            }
        });
        return root;
    }
}