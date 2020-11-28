package com.example.realkepstone.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TodayData {
    @SerializedName("food_name")
    @Expose
    private String foodName;
    @SerializedName("translated_name")
    @Expose
    private String translatedName;
    @SerializedName("food_star")
    @Expose
    private Float foodStar;
    @SerializedName("food_spicy")
    @Expose
    private Float foodSpicy;
    @SerializedName("food_dsc")
    @Expose
    private String foodDsc;
    @SerializedName("food_img_url")
    @Expose
    private String foodImgUrl;
    @SerializedName("tag")
    @Expose
    private List<String> tag = null;
    @SerializedName("allergy")
    @Expose
    private List<String> allergy = null;
    @SerializedName("today_avg_star")
    @Expose
    private Float todayAvgStar;

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

    public Float getFoodStar() {
        return foodStar;
    }

    public void setFoodStar(Float foodStar) {
        this.foodStar = foodStar;
    }

    public Float getFoodSpicy() {
        return foodSpicy;
    }

    public void setFoodSpicy(Float foodSpicy) {
        this.foodSpicy = foodSpicy;
    }


    public String getFoodDsc() {
        return foodDsc;
    }

    public void setFoodDsc(String foodDsc) {
        this.foodDsc = foodDsc;
    }

    public String getFoodImgUrl() {
        return foodImgUrl;
    }

    public void setFoodImgUrl(String foodImgUrl) {
        this.foodImgUrl = foodImgUrl;
    }

    public List<String> getTag() {
        return tag;
    }

    public void setTag(List<String> tag) {
        this.tag = tag;
    }

    public List<String> getAllergy() {
        return allergy;
    }

    public void setAllergy(List<String> allergy) {
        this.allergy = allergy;
    }

    public Float getTodayAvgStar() {
        return todayAvgStar;
    }

    public void setTodayAvgStar(Float todayAvgStar) {
        this.todayAvgStar = todayAvgStar;
    }



}
