package com.example.realkepstone.front;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.realkepstone.FrontActivity;
import com.example.realkepstone.R;
import com.example.realkepstone.server.ApiInterface;
import com.example.realkepstone.server.FindIdData;
import com.example.realkepstone.server.HttpClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FindidFragment extends Fragment {
    ApiInterface api;

    EditText email;
    ImageButton send=null;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_findid, container, false);
        api = HttpClient.getRetrofit().create( ApiInterface.class );

        email = (EditText) root.findViewById(R.id.pw);
        send = (ImageButton) root.findViewById(R.id.send);


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userEmail= email.getText().toString();

                requestPost(userEmail);
            }
        });

        return root;
    }

    public void requestPost(String userEmail) {
        FindIdData findIdData = new FindIdData(userEmail);
        Call<FindIdData> call = api.requestId( findIdData );

/*
- 없는 이메일: JsonResponse({"message": "INVALID_EMAIL"}, status=401)
- 해당 메일로 메일 전송 성공:
   JsonResponse({"message": "SEND_MAIL_SUCCESS"}, status=200)

 */
        call.enqueue( new Callback<FindIdData>() {
            @Override
            public void onResponse(Call<FindIdData> call, Response<FindIdData> response) {
                if(response.code()==200){
                    Toast.makeText(getContext().getApplicationContext(), R.string.findid, Toast.LENGTH_LONG).show();
                    FrontActivity activity = (FrontActivity) getActivity();
                    activity.fromfindId();

                }else if(response.code()==401){
                    Toast.makeText(getContext().getApplicationContext(), R.string.noid, Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getContext().getApplicationContext(), R.string.incorrect, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<FindIdData> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(), R.string.network, Toast.LENGTH_LONG).show();
            }
        } );
    }

}
