package com.example.realkepstone.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ButtonData {


    public ButtonData(Integer buttonNo) {
        this.buttonNo = buttonNo;
    }

    @SerializedName("button_no")
    @Expose
    private Integer buttonNo;

    public Integer getUserNo() {
        return buttonNo;
    }

    public void setUserNo(Integer buttonNo) {
        this.buttonNo = buttonNo;
    }
}
