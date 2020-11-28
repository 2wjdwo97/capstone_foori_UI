package com.example.realkepstone.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ChangeTagData {

    @SerializedName("user_no")
    @Expose
    private Integer userNo;
    @SerializedName("user_spicy")
    @Expose
    private Float userSpicy;
    @SerializedName("country_no")
    @Expose
    private Integer countryNo;
    @SerializedName("food_class_no")
    @Expose
    private List<Integer> foodClassNo = null;
    @SerializedName("tag_no")
    @Expose
    private List<Integer> tagNo = null;
    @SerializedName("allergy_no")
    @Expose
    private List<Integer> allergyNo = null;

    public ChangeTagData(Integer userNo, Float userSpicy, Integer countryNo, List<Integer> foodClassNo, List<Integer> tagNo, List<Integer> allergyNo) {
        this.userNo = userNo;
        this.userSpicy = userSpicy;
        this.countryNo = countryNo;
        this.foodClassNo = foodClassNo;
        this.tagNo = tagNo;
        this.allergyNo = allergyNo;
    }

    public Integer getUserNo() {
        return userNo;
    }

    public void setUserNo(Integer userNo) {
        this.userNo = userNo;
    }

    public float getUserSpicy() {
        return userSpicy;
    }

    public void setUserSpicy(float userSpicy) {
        this.userSpicy = userSpicy;
    }

    public Integer getCountryNo() {
        return countryNo;
    }

    public void setCountryNo(Integer countryNo) {
        this.countryNo = countryNo;
    }

    public List<Integer> getFoodClassNo() {
        return foodClassNo;
    }

    public void setFoodClassNo(List<Integer> foodClassNo) {
        this.foodClassNo = foodClassNo;
    }

    public List<Integer> getTagNo() {
        return tagNo;
    }

    public void setTagNo(List<Integer> tagNo) {
        this.tagNo = tagNo;
    }

    public List<Integer> getAllergyNo() {
        return allergyNo;
    }

    public void setAllergyNo(List<Integer> allergyNo) {
        this.allergyNo = allergyNo;
    }

}
