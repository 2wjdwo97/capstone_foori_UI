package com.example.realkepstone.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MyReviewData {


    @SerializedName("rev_no")
    @Expose
    private Integer revNo;
    @SerializedName("user_no_id")
    @Expose
    private Integer userNoId;
    @SerializedName("food_no_id")
    @Expose
    private Integer foodNoId;
    @SerializedName("rev_date")
    @Expose
    private String revDate;
    @SerializedName("rev_star")
    @Expose
    private Float revStar;
    @SerializedName("rev_spicy")
    @Expose
    private Float revSpicy;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @SerializedName("rev_contents")
    @Expose
    private String revContents;
    @SerializedName("food_img_url")
    @Expose
    private String url;
    @SerializedName("food_name")
    @Expose
    private String foodName;

    public Integer getRevNo() {
        return revNo;
    }

    public void setRevNo(Integer revNo) {
        this.revNo = revNo;
    }

    public Integer getUserNoId() {
        return userNoId;
    }

    public void setUserNoId(Integer userNoId) {
        this.userNoId = userNoId;
    }

    public Integer getFoodNoId() {
        return foodNoId;
    }

    public void setFoodNoId(Integer foodNoId) {
        this.foodNoId = foodNoId;
    }

    public String getRevDate() {
        return revDate;
    }

    public void setRevDate(String revDate) {
        this.revDate = revDate;
    }

    public float getRevStar() {
        return revStar;
    }

    public void setRevStar(float revStar) {
        this.revStar = revStar;
    }

    public float getRevSpicy() {
        return revSpicy;
    }

    public void setRevSpicy(float revSpicy) {
        this.revSpicy = revSpicy;
    }

    public String getRevContents() {
        return revContents;
    }

    public void setRevContents(String revContents) {
        this.revContents = revContents;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
}
