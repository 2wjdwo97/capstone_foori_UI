package com.example.realkepstone;

import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    public int getUser_no() {
        return user_no;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String food_name;
    public void setUser_no(int user_no) {
        this.user_no = user_no;
    }

    private int user_no;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    private String language;

}

