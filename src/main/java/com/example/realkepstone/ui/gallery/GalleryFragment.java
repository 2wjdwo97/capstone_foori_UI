package com.example.realkepstone.ui.gallery;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.realkepstone.MainActivity;
import com.example.realkepstone.R;
import com.example.realkepstone.data.FoodAfter;
import com.example.realkepstone.server.ApiInterface;
import com.example.realkepstone.server.HttpClient;
import com.example.realkepstone.ui.BagFragment;
import com.example.realkepstone.ui.ResultFragment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GalleryFragment extends Fragment {

    private ImageView ganpan;
    private ImageView menu;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);


        menu = (ImageView) root.findViewById(R.id.menu);
        ganpan = (ImageView) root.findViewById(R.id.ganpan);

        ganpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction=getActivity().getSupportFragmentManager().beginTransaction();
                SignGalleryFragment mfragment=new SignGalleryFragment();
                transaction.replace(R.id.Main_Frame, mfragment,"not");
                transaction.commit();
            }
        });
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction=getActivity().getSupportFragmentManager().beginTransaction();
                MenuGalleryFragment mfragment=new MenuGalleryFragment();
                transaction.replace(R.id.Main_Frame, mfragment,"not");
                transaction.commit();

            }
        });




        return root;
    }


}