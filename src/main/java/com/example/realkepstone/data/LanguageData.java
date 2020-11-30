package com.example.realkepstone.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LanguageData{


    public LanguageData(Integer user_no,String lang) {
        this.lang = lang;
        this.user_no = user_no;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @SerializedName("lang_code")
    @Expose
    private String lang;

    public Integer getUser_no() {
        return user_no;
    }

    public void setUser_no(Integer user_no) {
        this.user_no = user_no;
    }

    @SerializedName("user_no")
    @Expose
    private Integer user_no;

}
