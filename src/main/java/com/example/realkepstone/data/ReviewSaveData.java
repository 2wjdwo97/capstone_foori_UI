package com.example.realkepstone.data;


import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReviewSaveData {

    @SerializedName("user_no")
    @Expose
    private Integer userNo=0;
    @SerializedName("food_name")
    @Expose
    private String foodName="";
    @SerializedName("rev_star")
    @Expose
    private Float revStar;
    @SerializedName("rev_spicy")
    @Expose
    private Float revSpicy;
    @SerializedName("rev_contents")
    @Expose
    private String revContents="/t";
    @SerializedName("tag_no")
    @Expose
    private List<Integer> tagNo = null;

    public ReviewSaveData(Integer userNo, String foodName, Float revStar, Float revSpicy, String revContents, List<Integer> tagNo) {
        this.userNo = userNo;
        this.foodName = foodName;
        this.revStar = revStar;
        this.revSpicy = revSpicy;
        this.revContents = revContents;
        this.tagNo = tagNo;
    }

    public Integer getUserNo() {
        return userNo;
    }

    public void setUserNo(Integer userNo) {
        this.userNo = userNo;
    }

    public ReviewSaveData withUserNo(Integer userNo) {
        this.userNo = userNo;
        return this;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public ReviewSaveData withFoodName(String foodName) {
        this.foodName = foodName;
        return this;
    }

    public Float getRevStar() {
        return revStar;
    }

    public void setRevStar(Float revStar) {
        this.revStar = revStar;
    }

    public ReviewSaveData withRevStar(Float revStar) {
        this.revStar = revStar;
        return this;
    }

    public Float getRevSpicy() {
        return revSpicy;
    }

    public void setRevSpicy(Float revSpicy) {
        this.revSpicy = revSpicy;
    }

    public ReviewSaveData withRevSpicy(Float revSpicy) {
        this.revSpicy = revSpicy;
        return this;
    }

    public String getRevContents() {
        return revContents;
    }

    public void setRevContents(String revContents) {
        this.revContents = revContents;
    }

    public ReviewSaveData withRevContents(String revContents) {
        this.revContents = revContents;
        return this;
    }

    public List<Integer> getTagNo() {
        return tagNo;
    }

    public void setTagNo(List<Integer> tagNo) {
        this.tagNo = tagNo;
    }

    public ReviewSaveData withTagNo(List<Integer> tagNo) {
        this.tagNo = tagNo;
        return this;
    }

}