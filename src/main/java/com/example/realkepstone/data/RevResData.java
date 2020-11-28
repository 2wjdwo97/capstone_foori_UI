package com.example.realkepstone.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RevResData {
    public RevResData(String foodName, String translatedName,String foodImgUrl) {
        this.foodName = foodName;
        this.translatedName=translatedName;
        this.foodImgUrl = foodImgUrl;
    }
    @SerializedName("food_name")
    @Expose
    private String foodName;
    @SerializedName("translated_name")
    @Expose
    private String translatedName;
    @SerializedName("food_img_url")
    @Expose
    private String foodImgUrl;

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getTranslatedName() {
        return translatedName;
    }

    public void setTranslatedName(String translatedName) {
        this.translatedName = translatedName;
    }

    public String getFoodImgUrl() {
        return foodImgUrl;
    }

    public void setFoodImgUrl(String foodImgUrl) {
        this.foodImgUrl = foodImgUrl;
    }
}