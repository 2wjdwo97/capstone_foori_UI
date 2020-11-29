package com.example.realkepstone.server;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResLoginData {
    @SerializedName("user_no")
    @Expose
    int user_no;
    @SerializedName("access_token")
    @Expose
    String access_token;

    public void setUser_no(int user_no) {
        this.user_no = user_no;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getUser_no() {
        return user_no;
    }
}




