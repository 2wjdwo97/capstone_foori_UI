package com.example.realkepstone.front;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.realkepstone.FrontActivity;
import com.example.realkepstone.R;

import java.util.Timer;
import java.util.TimerTask;

public class FrontFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_front, container, false);
        Timer timer =new Timer();

        timer.schedule(m_task, 2000);

        return root;
    }

    TimerTask m_task = new TimerTask(){
        @Override
        public void run() {
            FrontActivity activity = (FrontActivity) getActivity();
            activity.frontfragmentChange();
        }
    };
}