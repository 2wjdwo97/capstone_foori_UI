package com.example.realkepstone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.realkepstone.MainActivity;
import com.example.realkepstone.R;
import com.example.realkepstone.SharedViewModel;
import com.example.realkepstone.data.PasswordChangeData;
import com.example.realkepstone.server.ApiInterface;
import com.example.realkepstone.server.HttpClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyPage_PasswordActivity extends AppCompatActivity {
    ApiInterface api;
    int user_no;
    private SharedViewModel model;
    EditText password;
    EditText new_password;
    EditText confirm;
    ImageButton send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page__password);

        Intent intent = getIntent();
        user_no = intent.getIntExtra("user_no", 0);

        Toolbar toolbar = (Toolbar)findViewById(R.id.tb_password);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Change Password");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        password=findViewById(R.id.password);
        new_password=findViewById(R.id.new_password);
        confirm=findViewById(R.id.new_confirm);

        send=findViewById(R.id.send);

        Log.e("user_no", String.valueOf(user_no));
        api = HttpClient.getRetrofit().create( ApiInterface.class );


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestPost(user_no, password.getText().toString(),new_password.getText().toString(), confirm.getText().toString());
                finish();
            }
        });
//((MainActivity) getActivity()) -> this
        if (this.getSupportActionBar() == null)
            Log.d("null", "null");
        this.getSupportActionBar().setTitle("change PW");
    }

    public void requestPost(int user_no, String password, String new_password, String confirm) {
        PasswordChangeData passwordChangeData = new PasswordChangeData(user_no, password, new_password, confirm);
        Call<PasswordChangeData> call = api.requestpwchange(passwordChangeData);

        call.enqueue( new Callback<PasswordChangeData>() {
            @Override
            public void onResponse(Call<PasswordChangeData> call, Response<PasswordChangeData> response) {
                if(response.code()==200){
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.successchange), Toast.LENGTH_LONG).show();
                    Log.e("ChangePW", String.valueOf(response.code()));
                }else if(response.code()==401){
                    Log.e("ChangePW", String.valueOf(response.code()));
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.incorrect), Toast.LENGTH_LONG).show();

                }
                else if(response.code()==402){
                    Log.e("ChangePW", String.valueOf(response.code()));
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.confirmfail), Toast.LENGTH_LONG).show();
                }
                else{
                }
            }

            @Override
            public void onFailure(Call<PasswordChangeData> call, Throwable t) {
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