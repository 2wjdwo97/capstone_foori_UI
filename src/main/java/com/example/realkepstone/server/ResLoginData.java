package com.example.realkepstone.server;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResLoginData {
    @SerializedName("user_no")
    @Expose
    int user_no;


    public int getUser_no() {
        return user_no;
    }
}


