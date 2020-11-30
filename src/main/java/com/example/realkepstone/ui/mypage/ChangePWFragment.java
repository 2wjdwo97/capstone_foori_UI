package com.example.realkepstone.ui.mypage;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
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

public class ChangePWFragment extends Fragment {

    ApiInterface api;
    int user_no;
    private SharedViewModel model;
    EditText password;
    EditText new_password;
    EditText confirm;
    ImageButton send;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_change_pw, container, false);

        password=root.findViewById(R.id.password);
        new_password=root.findViewById(R.id.new_password);
        confirm=root.findViewById(R.id.new_confirm);
        send=root.findViewById(R.id.send);
        model = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        user_no=model.getUser_no();
        Log.d("loginusedfdsfsdfrno", String.valueOf(user_no));
        api = HttpClient.getRetrofit().create( ApiInterface.class );


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestPost(user_no, password.getText().toString(),new_password.getText().toString(), confirm.getText().toString());
            }
        });

        if (((MainActivity) getActivity()).getSupportActionBar() == null)
            Log.d("null", "null");
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("change PW");

        return root;
    }

    public void requestPost(int user_no, String password, String new_password, String confirm) {
        PasswordChangeData passwordChangeData = new PasswordChangeData(user_no, password, new_password, confirm);
        Call<PasswordChangeData> call = api.requestpwchange(passwordChangeData);

        call.enqueue( new Callback<PasswordChangeData>() {
            @Override
            public void onResponse(Call<PasswordChangeData> call, Response<PasswordChangeData> response) {
                if(response.code()==200){
                    Toast.makeText(getContext().getApplicationContext(), getResources().getString(R.string.successchange), Toast.LENGTH_LONG).show();
                    Log.e("ChangePW", String.valueOf(response.code()));
                }else if(response.code()==401){
                    Log.e("ChangePW", String.valueOf(response.code()));
                    Toast.makeText(getContext().getApplicationContext(), getResources().getString(R.string.incorrect), Toast.LENGTH_LONG).show();

                }
                else if(response.code()==402){
                    Log.e("ChangePW", String.valueOf(response.code()));
                    Toast.makeText(getContext().getApplicationContext(), getResources().getString(R.string.confirmfail), Toast.LENGTH_LONG).show();
                }
                else{
                }
            }

            @Override
            public void onFailure(Call<PasswordChangeData> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(), getResources().getString(R.string.network), Toast.LENGTH_LONG).show();
            }
        } );
    }




}