package com.example.realkepstone.ui.home;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.realkepstone.R;
import com.example.realkepstone.adapter.HighestAdapter;
import com.example.realkepstone.data.ButtonData;
import com.example.realkepstone.data.HomeData;
import com.example.realkepstone.server.ApiInterface;
import com.example.realkepstone.server.HttpClient;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MostFragment extends Fragment {

    private int button_no;
    ApiInterface api;
    private HighestAdapter adapter;
    private RecyclerView recyclerView;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_most, container, false);
        api = HttpClient.getRetrofit().create( ApiInterface.class );
        adapter = new HighestAdapter();

        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        Bundle bundle=getArguments();
        assert getArguments() != null;
        button_no = (getArguments().getInt("json"));
        Log.e("button_no", String.valueOf(button_no));

        requestPost(button_no);


        return root;
    }

    void requestPost(int button_no){
        ButtonData buttonData = new ButtonData(button_no);
        Call<List<HomeData>> call = api.requestHome( buttonData );
        ProgressDialog mProgressDialog = new ProgressDialog(getContext());
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage("Loading.........");
        mProgressDialog.show();
        // 비동기로 백그라운드 쓰레드로 동작
        call.enqueue( new Callback<List<HomeData>>() {
            // 통신성공 후 텍스트뷰에 결과값 출력
            @Override
            public void onResponse(Call<List<HomeData>> call, Response<List<HomeData>> response) {
                if(response.code()==200){
                    Log.e("myrevies", String.valueOf(response.code()));
                    if (mProgressDialog.isShowing())
                        mProgressDialog.dismiss();

                    for(int i=0; i<response.body().size(); i++){
                        adapter.addItem(response.body().get(i));
                        adapter.notifyDataSetChanged();

                    }

                }
                else if(response.code()==201){
                    if (mProgressDialog.isShowing())
                        mProgressDialog.dismiss();
                    Log.e("myrevies", String.valueOf(response.code()));
                }
                else{
                    if (mProgressDialog.isShowing())
                        mProgressDialog.dismiss();
                    Log.e("myrevies", String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<List<HomeData>> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(), R.string.network, Toast.LENGTH_LONG).show();
                if (mProgressDialog.isShowing())
                    mProgressDialog.dismiss();
                Log.e("myrevies", "failure");

            }
        } );
    }
}