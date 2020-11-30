package com.example.realkepstone;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.realkepstone.FrontActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.realkepstone.server.ApiInterface;
import com.example.realkepstone.server.HttpClient;
import com.example.realkepstone.server.ReqLoginData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyPage_DeleteActivity extends AppCompatActivity {
    EditText id;
    EditText pw;
    ImageButton send;

    ApiInterface api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page__delete);
        api = HttpClient.getRetrofit().create( ApiInterface.class );

        Intent intent = getIntent();

        Toolbar toolbar = (Toolbar)findViewById(R.id.tb_delete);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Delete Account");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        id=findViewById(R.id.id);
        pw=findViewById(R.id.pw);
        send=findViewById(R.id.send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestPost(id.getText().toString(),pw.getText().toString());
            }
        });
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
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.quit), Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(getApplicationContext(), FrontActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else if(response.code()==401){
                    Log.e("quit", String.valueOf(response.code()));

                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.noid), Toast.LENGTH_LONG).show();
                }
                else{
                    Log.e("quit", String.valueOf(response.code()));

                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.error), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ReqLoginData> call, Throwable t) {
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.network), Toast.LENGTH_LONG).show();


            }
        } );
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            // 뒤로가기 버튼
            case android.R.id.home:{
                finish();
                overridePendingTransition(R.anim.exit_to_right, R.anim.exit_to_right);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}