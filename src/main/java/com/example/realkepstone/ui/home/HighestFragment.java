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
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.realkepstone.MainActivity;
import com.example.realkepstone.R;
import com.example.realkepstone.SharedViewModel;
import com.example.realkepstone.adapter.HighestAdapter;
import com.example.realkepstone.adapter.MyReviewAdapter;
import com.example.realkepstone.adapter.RecyclerAdapter;
import com.example.realkepstone.data.ButtonData;
import com.example.realkepstone.data.HomeData;
import com.example.realkepstone.data.MyReview;
import com.example.realkepstone.server.ApiInterface;
import com.example.realkepstone.server.HttpClient;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HighestFragment extends Fragment {

    int user_no;
    private SharedViewModel model;
    private int button_no;
    ApiInterface api;
    private HighestAdapter adapter;
    private RecyclerView recyclerView;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_highest, container, false);

        api = HttpClient.getRetrofit().create( ApiInterface.class );
        adapter = new HighestAdapter();
        model = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        Bundle bundle = getArguments();
        assert bundle != null;
        user_no = bundle.getInt("user_no");
        button_no = bundle.getInt("button_no");
//        Log.d("highestFrg_user_no", String.valueOf(user_no));
//        Log.d("highestFrg_button_no", String.valueOf(button_no));

        requestPost(user_no,button_no);

        return root;
    }

    void requestPost(int user_no, int button_no){
        ButtonData buttonData = new ButtonData(user_no,button_no);
        Call<List<HomeData>> call = api.requestMost( buttonData );
        // Set up progress before call

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
                    Log.e("myrevies", String.valueOf(response.code()));
                    if (mProgressDialog.isShowing())
                        mProgressDialog.dismiss();
                }
                else{
                    Log.e("myrevies", String.valueOf(response.code()));
                    if (mProgressDialog.isShowing())
                        mProgressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<List<HomeData>> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(),getResources().getString( R.string.network), Toast.LENGTH_LONG).show();
                Log.e("myrevies", "fail");

                if (mProgressDialog.isShowing())
                    mProgressDialog.dismiss();
            }
        } );
    }

}