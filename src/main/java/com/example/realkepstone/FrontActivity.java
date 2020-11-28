package com.example.realkepstone;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import java.util.Locale;

public class FrontActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.front);

        Intent intent = getIntent(); /*데이터 수신*/

        if( intent.getExtras() != null)
        {
            String language = intent.getExtras().getString("language"); /*String형*/

            if(language!=null){
                Locale eg = Locale.ENGLISH;
                Configuration config = new Configuration( );
                config.locale = eg;
                getResources( ).updateConfiguration( config, getResources( ).getDisplayMetrics( ) );

            }
        }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
    public void tofindPw() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        navController.navigate(R.id.action_nav_login_to_nav_findpw);
    }

    public void joinfragmentChange(Bundle bundle) {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        navController.navigate(R.id.action_nav_login_to_nav_joinafter, bundle);
    }
    public void frontfragmentChange() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        navController.navigate(R.id.action_nav_front_to_nav_login);
    }

    public void loginfragmentChange() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        navController.navigate(R.id.action_nav_login_to_nav_join);
    }
    public void joinafterfragmentChange() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        navController.navigate(R.id.action_nav_joinafter_to_nav_login);
    }

    public void tofindId() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        navController.navigate(R.id.action_nav_login_to_nav_findid);
    }
    public void fromfindId(){
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        navController.navigate(R.id.action_nav_findid_to_nav_login);
    }
    public void jointoLogin(){
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        navController.navigate(R.id.action_nav_join_to_nav_login);
    }

}
