package com.example.realkepstone.server;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TagData {

    @SerializedName("user_no")
    @Expose
    private int userNo;
    @SerializedName("food_class_no")
    @Expose
    private List<Integer> foodClassNo = null;
    @SerializedName("tag_no")
    @Expose
    private List<Integer> tagNo = null;
    @SerializedName("allergy_no")
    @Expose
    private List<Integer> allergyNo = null;

    /**
     * No args constructor for use in serialization
     *
     */
    /**
     *
     * @param userNo
     * @param foodClassNo
     * @param tagNo
     * @param allergyNo
     */
    public TagData(int userNo, List<Integer> foodClassNo, List<Integer> tagNo, List<Integer> allergyNo) {
        super();
        this.userNo = userNo;
        this.foodClassNo = foodClassNo;
        this.tagNo = tagNo;
        this.allergyNo = allergyNo;
    }

    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
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