package com.example.realkepstone.server;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JoinData {



    public JoinData(String id, String userPw, String pwConfirm, String userEmail, String userName, String userBirth, int userSpicy, int countryNo) {
        this.user_id = id;
        this.user_pw = userPw;
        this.pw_confirm=pwConfirm;
        this.user_email=userEmail;
        this.user_name=userName;
        this.user_birth=userBirth;
        this.user_spicy=userSpicy;
        this.country_no=countryNo;
    }
    @SerializedName("user_id")
    @Expose
    private String user_id;
    @SerializedName("user_pw")
    @Expose
    private String user_pw;
    @SerializedName("pw_confirm")
    @Expose
    private String pw_confirm;
    @SerializedName("user_email")
    @Expose
    private String user_email;
    @SerializedName("user_name")
    @Expose
    private String user_name;
    @SerializedName("user_birth")
    @Expose
    private String user_birth;
    @SerializedName("user_spicy")
    @Expose
    private Integer user_spicy;
    @SerializedName("country_no")
    @Expose
    private Integer country_no;

    public String getUserId() {
        return user_id;
    }

    public void setUserId(String userId) {
        this.user_id = userId;
    }

    public String getUserPw() {
        return user_pw;
    }

    public void setUserPw(String userPw) {
        this.user_pw = userPw;
    }

    public String getPwConfirm() {
        return pw_confirm;
    }

    public void setPwConfirm(String pwConfirm) {
        this.pw_confirm = pwConfirm;
    }

    public String getUserEmail() {
        return user_email;
    }

    public void setUserEmail(String userEmail) {
        this.user_email = userEmail;
    }

    public String getUserName() {
        return user_name;
    }

    public void setUserName(String userName) {
        this.user_name = userName;
    }

    public String getUserBirth() {
        return user_birth;
    }

    public void setUserBirth(String userBirth) {
        this.user_birth = userBirth;
    }

    public Integer getUserSpicy() {
        return user_spicy;
    }

    public void setUserSpicy(Integer userSpicy) {
        this.user_spicy = userSpicy;
    }

    public Integer getCountryNo() {
        return country_no;
    }

    public void setCountryNo(Integer countryNo) {
        this.country_no = countryNo;
    }

}