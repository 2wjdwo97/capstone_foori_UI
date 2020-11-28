package com.example.realkepstone.data;

import android.content.Context;

import com.example.realkepstone.R;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HomeData implements Serializable {

    @SerializedName("food_name")
    @Expose
    private String foodName;

    public String getTranslated_name() {
        return translated_name;
    }

    public void setTranslated_name(String translated_name) {
        this.translated_name = translated_name;
    }

    public void setTag(List<String> tag) {
        this.tag = tag;
    }

    @SerializedName("translated_name")
    @Expose
    private String translated_name;
    @SerializedName("food_star")
    @Expose
    private Float foodStar;
    @SerializedName("food_dsc")
    @Expose
    private String foodDsc;
    @SerializedName("food_img_url")
    @Expose
    private String foodImgUrl;
    @SerializedName("tag")
    @Expose
    private List<String> tag = null;

    public void setFoodStar(Float foodStar) {
        this.foodStar = foodStar;
    }



    @SerializedName("allergy")
    @Expose
    private List<String> allergy = null;


    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public float getFoodStar() {
        return foodStar;
    }

    public void setFoodStar(float foodStar) {
        this.foodStar = foodStar;
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

    public void setTagNo(List<String> tag) {
        this.tag = tag;
    }

    public List<String> getAllergy() {
        return allergy;
    }

    public void setAllergy(List<String> allergy) {
        this.allergy = allergy;
    }




}
