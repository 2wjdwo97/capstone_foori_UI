package com.example.realkepstone.ui.mypage;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.realkepstone.FrontActivity;
import com.example.realkepstone.MainActivity;
import com.example.realkepstone.R;
import com.example.realkepstone.server.ApiInterface;
import com.example.realkepstone.server.HttpClient;
import com.example.realkepstone.server.ReqLoginData;
import com.example.realkepstone.server.ResLoginData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuitFragment extends Fragment {

    EditText id;
    EditText pw;
    ImageButton send;

    ApiInterface api;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_quit, container, false);
        api = HttpClient.getRetrofit().create( ApiInterface.class );

        id=root.findViewById(R.id.id);
        pw=root.findViewById(R.id.pw);
        send=root.findViewById(R.id.send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestPost(id.getText().toString(),pw.getText().toString());
            }
        });

        return root;
    }

    public void requestPost(String id, String pw) {
        ReqLoginData reqLoginData = new ReqLoginData( id, pw);
        Call<ReqLoginData> call = api.requestDelete( reqLoginData );

        // 비동기로 백그라운드 쓰레드로 동작
        call.enqueue( new Callback<ReqLoginData>() {
            // 통신성공 후 텍스트뷰에 결과값 출력
            @Override
            public void onResponse(Call<ReqLoginData> call, Response<ReqLoginData> response) {
                if(response.code()==200){
                    Log.e("quit", String.valueOf(response.code()));
                    Toast.makeText(getContext().getApplicationContext(), R.string.quit, Toast.LENGTH_LONG).show();
                    MainActivity activity = (MainActivity) getActivity();
                    activity.finish();

                }
                else if(response.code()==401){
                    Log.e("quit", String.valueOf(response.code()));

                    Toast.makeText(getContext().getApplicationContext(), R.string.noid, Toast.LENGTH_LONG).show();
                }
                else{
                    Log.e("quit", String.valueOf(response.code()));

                    Toast.makeText(getContext().getApplicationContext(), R.string.error, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ReqLoginData> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(), R.string.network, Toast.LENGTH_LONG).show();


            }
        } );
    }
}