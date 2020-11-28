package com.example.realkepstone.server;

import android.widget.EditText;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReqLoginData {
    @SerializedName("user_id")
    @Expose
    String user_id;
    @SerializedName("user_pw")
    @Expose
    String user_pw;

    public ReqLoginData(String id, String pw ) {
        this.user_id = id;
        this.user_pw = pw;
    }
}