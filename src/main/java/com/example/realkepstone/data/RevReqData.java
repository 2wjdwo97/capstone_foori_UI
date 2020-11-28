package com.example.realkepstone.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RevReqData {
    public RevReqData(Integer userNo) {
        this.userNo = userNo;
    }

    @SerializedName("user_no")
    @Expose
    private Integer userNo;

    public Integer getUserNo() {
        return userNo;
    }

    public void setUserNo(Integer userNo) {
        this.userNo = userNo;
    }

}