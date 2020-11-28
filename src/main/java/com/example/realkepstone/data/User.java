package com.example.realkepstone.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class User {
    @SerializedName("userId")
    private String userId;
    @SerializedName("userPw")
    private String userPw;


    public String getUserId(){
        return userId;
    }
    public String getUserpw(){
        return userPw;
    }
    public void setId(String id){
        this.userId=id;
    }
    public void setPw(String pw){
        this.userPw=pw;
    }


}
