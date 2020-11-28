package com.example.realkepstone.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;
public class FoodAfter implements Serializable {

    @SerializedName("food_korName")
    @Expose
    private List<String> foodKorName = null;
    @SerializedName("food_engName")
    @Expose
    private List<String> foodEngName = null;
    @SerializedName("food_description")
    @Expose
    private List<String> foodDescription = null;
    @SerializedName("food_ingredients")
    @Expose
    private List<List<String>> foodIngredients = null;
    @SerializedName("food_allergy")
    @Expose
    private List<List<String>> foodAllergy = null;
    @SerializedName("recommend_food")
    @Expose
    private List<Integer> recommendFood = null;
    @SerializedName("food_img_url")
    @Expose
    private List<String> foodImgUrl = null;
    @SerializedName("user_number")
    @Expose
    private Integer userNumber=0;
    @SerializedName("food_star")
    @Expose
    private List<Integer> star = null;

    public List<Integer> getStar() {
        return star;
    }

    public void setStar(List<Integer> star) {
        this.star = star;
    }

    @SerializedName("cookies")
    @Expose
    private List<String> cookies = null;

    public List<String> getCookies() {
        return cookies;
    }

    public void setCookies(List<String> cookies) {
        this.cookies = cookies;
    }

    public List<String> getFoodKorName() {
        return foodKorName;
    }

    public void setFoodKorName(List<String> foodKorName) {
        this.foodKorName = foodKorName;
    }

    public List<String> getFoodEngName() {
        return foodEngName;
    }

    public void setFoodEngName(List<String> foodEngName) {
        this.foodEngName = foodEngName;
    }

    public List<String> getFoodDescription() {
        return foodDescription;
    }

    public void setFoodDescription(List<String> foodDescription) {
        this.foodDescription = foodDescription;
    }

    public List<List<String>> getFoodIngredients() {
        return foodIngredients;
    }

    public void setFoodIngredients(List<List<String>> foodIngredients) {
        this.foodIngredients = foodIngredients;
    }

    public List<List<String>> getFoodAllergy() {
        return foodAllergy;
    }

    public void setFoodAllergy(List<List<String>> foodAllergy) {
        this.foodAllergy = foodAllergy;
    }

    public List<Integer> getRecommendFood() {
        return recommendFood;
    }

    public void setRecommendFood(List<Integer> recommendFood) {
        this.recommendFood = recommendFood;
    }

    public List<String> getFoodImgUrl() {
        return foodImgUrl;
    }

    public void setFoodImgUrl(List<String> foodImgUrl) {
        this.foodImgUrl = foodImgUrl;
    }

    public Integer getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(Integer userNumber) {
        this.userNumber = userNumber;
    }

}