package com.example.realkepstone.ui.mypage;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.realkepstone.R;
import com.example.realkepstone.SharedViewModel;
import com.example.realkepstone.adapter.MyReviewAdapter;
import com.example.realkepstone.adapter.RecyclerAdapter;
import com.example.realkepstone.data.Food;
import com.example.realkepstone.data.MyReview;
import com.example.realkepstone.data.MyReviewData;
import com.example.realkepstone.data.RevReqData;
import com.example.realkepstone.data.RevResData;
import com.example.realkepstone.server.ApiInterface;
import com.example.realkepstone.server.HttpClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReviewsFragment extends Fragment {

    ApiInterface api;
    int user_no;
    private SharedViewModel model;
    private RecyclerView recyclerView;
    private MyReviewAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_myreivews, container, false);

        model = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        user_no=model.getUser_no();
        Log.d("loginusedfdsfsdfrno", String.valueOf(user_no));
        api = HttpClient.getRetrofit().create( ApiInterface.class );
        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);
        adapter = new MyReviewAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        requestPost(user_no);


        return root;
    }

    public void requestPost(int user_no) {
        RevReqData revReqData = new RevReqData(user_no);
        Call<List<MyReviewData>> call = api.requestMyReview( revReqData );

        // 비동기로 백그라운드 쓰레드로 동작
        call.enqueue( new Callback<List<MyReviewData>>() {
            // 통신성공 후 텍스트뷰에 결과값 출력
            @Override
            public void onResponse(Call<List<MyReviewData>> call, Response<List<MyReviewData>> response) {
                if(response.code()==200){
                    Log.e("myrevies", response.body().get(0).getFoodName());

                    List<String> listTitle = new ArrayList<String>();
                    List<Float> listStar = new ArrayList<>();
                    List<Float> listRed = new ArrayList<>();
                    List<String> listWhen = new ArrayList<>();
                    List<String> listContent = new ArrayList<>();
                    List<String> listUrl=new ArrayList<>();

                    for (int i = 0; i < response.body().size(); i++) {
                        listTitle.add(response.body().get(i).getFoodName());
                        listStar.add(response.body().get(i).getRevStar());
                        listRed.add(response.body().get(i).getRevSpicy());
                        listWhen.add(response.body().get(i).getRevDate());
                        listContent.add(response.body().get(i).getRevContents());
                        listUrl.add(response.body().get(i).getUrl());

                    }
                    for (int i = 0; i < response.body().size(); i++) {
                        // 각 List의 값들을 data 객체에 set 해줍니다.
                        MyReview data = new MyReview();
                        data.setTitle(listTitle.get(i));
                        data.setRed(listRed.get(i));
                        data.setStar(listStar.get(i));
                        data.setContent(listContent.get(i));
                        data.setWhen(listWhen.get(i));
                        data.setUrl(listUrl.get(i));

                        Log.e("urlgood", data.getUrl());
                        // 각 값이 들어간 data를 adapter에 추가합니다.
                        adapter.addItem(data);
                        adapter.notifyDataSetChanged();

                    }
                }
                else{
                    Log.e("myreview",String.valueOf(response.code()));
                    Toast.makeText(getContext().getApplicationContext(), getResources().getString(R.string.incorrect), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<MyReviewData>> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(),getResources().getString( R.string.network), Toast.LENGTH_LONG).show();


            }
        } );
    }


}