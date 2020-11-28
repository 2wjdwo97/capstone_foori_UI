package com.example.realkepstone.server;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FindIdData {

    @SerializedName("user_email")
    @Expose
    private String userEmail;
    public FindIdData(String email) {
        this.userEmail=email;
    }
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

}