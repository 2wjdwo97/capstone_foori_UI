package com.example.realkepstone.server;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FindpwData {

    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("user_email")
    @Expose
    private String userEmail;

    /**
     * No args constructor for use in serialization
     *
     */
    public FindpwData() {
    }

    /**
     *
     * @param userEmail
     * @param userId
     */
    public FindpwData(String userId, String userEmail) {
        super();
        this.userId = userId;
        this.userEmail = userEmail;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
