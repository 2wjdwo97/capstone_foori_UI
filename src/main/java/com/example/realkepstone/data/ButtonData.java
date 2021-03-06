package com.example.realkepstone.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ButtonData {


    public ButtonData(Integer user_no,Integer buttonNo) {
        this.buttonNo = buttonNo;
        this.user_no = user_no;
    }

    @SerializedName("button_no")
    @Expose
    private Integer buttonNo;

    public Integer getButtonNo() {
        return buttonNo;
    }

    public void setButtonNo(Integer buttonNo) {
        this.buttonNo = buttonNo;
    }

    public Integer getUser_no() {
        return user_no;
    }

    public void setUser_no(Integer user_no) {
        this.user_no = user_no;
    }

    @SerializedName("user_no")
    @Expose
    private Integer user_no;

}
