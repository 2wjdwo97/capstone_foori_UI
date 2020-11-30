package com.example.realkepstone.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.realkepstone.MainActivity;
import com.example.realkepstone.R;
import com.example.realkepstone.data.HomeData;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class RightFragment extends Fragment {

    private Button most;
    private Button highest;
    private int button_no;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_rightview, container, false);

        highest = root.findViewById(R.id.highest);
        most = root.findViewById(R.id.most);

        Bundle bundle = getArguments();
        assert getArguments() != null;
        button_no = (getArguments().getInt("json"));
        Log.e("button_no", String.valueOf(button_no));

        HighestFragment fragment = new HighestFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Bundle bundle2 = new Bundle();
        bundle2.putInt("json", button_no);
        fragment.setArguments(bundle2); //data being send to SecondFragment

        fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_right);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.subFrame, fragment);
        fragmentTransaction.commit();

        highest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(view.isSelected()){
                    view.setSelected(false);
                    most.setSelected(true);
                }
                else{
                    view.setSelected(true);
                    most.setSelected(false);
                }

                HighestFragment fragment = new HighestFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                Bundle bundle2=new Bundle();
                bundle2.putInt("json", button_no);
                fragment.setArguments(bundle2); //data being send to SecondFragment

                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_right);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.subFrame, fragment);
                Log.e("rightFragment","highest rated");
                fragmentTransaction.commit();
            }
        });

        most.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(view.isSelected()){
                    view.setSelected(false);
                    highest.setSelected(true);
                }
                else{
                    view.setSelected(true);
                    highest.setSelected(false);

                }
                MostFragment fragment = new MostFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                Bundle bundle2=new Bundle();
                bundle2.putInt("json", button_no);
                fragment.setArguments(bundle2); //data being send to SecondFragment

                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_right);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.subFrame, fragment);
                fragmentTransaction.commit();
                Log.e("rightFragment?","most reviewed");

            }
        });

        highest.setSelected(true);
        return root;
    }
}
