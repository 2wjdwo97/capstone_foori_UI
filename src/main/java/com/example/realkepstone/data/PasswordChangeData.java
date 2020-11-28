package com.example.realkepstone.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PasswordChangeData {
    public PasswordChangeData(Integer userNo, String userPw, String pwNew, String pwConfirm) {
        this.userNo = userNo;
        this.userPw = userPw;
        this.pwNew = pwNew;
        this.pwConfirm = pwConfirm;
    }

    @SerializedName("user_no")
    @Expose
    private Integer userNo;
    @SerializedName("user_pw")
    @Expose
    private String userPw;
    @SerializedName("pw_new")
    @Expose
    private String pwNew;
    @SerializedName("pw_confirm")
    @Expose
    private String pwConfirm;

    public Integer getUserNo() {
        return userNo;
    }

    public void setUserNo(Integer userNo) {
        this.userNo = userNo;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public String getPwNew() {
        return pwNew;
    }

    public void setPwNew(String pwNew) {
        this.pwNew = pwNew;
    }

    public String getPwConfirm() {
        return pwConfirm;
    }

    public void setPwConfirm(String pwConfirm) {
        this.pwConfirm = pwConfirm;
    }
}
