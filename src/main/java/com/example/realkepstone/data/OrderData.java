package com.example.realkepstone.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OrderData {
    public OrderData(Integer userNo, List<String> foodName) {
        this.userNo = userNo;
        this.foodName = foodName;
    }

    @SerializedName("user_no")
    @Expose
    private Integer userNo;
    @SerializedName("food_name")
    @Expose
    private List<String> foodName = null;

    public Integer getUserNo() {
        return userNo;
    }

    public void setUserNo(Integer userNo) {
        this.userNo = userNo;
    }

    public List<String> getFoodName() {
        return foodName;
    }

    public void setFoodName(List<String> foodName) {
        this.foodName = foodName;
    }
}
