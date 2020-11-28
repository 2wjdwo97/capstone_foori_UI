package com.example.realkepstone.data;

import java.io.Serializable;

public class Food implements Serializable {

    private String kor;
    private String eng;

    private String des;
    private String allergy;
    private String spicy;
    private String ingre;
    private int star;

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getRecommed() {
        return recommed;
    }

    public void setRecommed(int recommed) {
        this.recommed = recommed;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private int resId;

    private int recommed;
    private String url=null;


    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    private boolean select=false;


    public String getKor() {
        return kor;
    }

    public void setKor(String kor) {
        this.kor = kor;
    }

    public String getEng() {
        return eng;
    }

    public void setEng(String eng) {
        this.eng = eng;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public String getSpicy() {
        return spicy;
    }

    public void setSpicy(String spicy) {
        this.spicy = spicy;
    }

    public String getIngre() {
        return ingre;
    }

    public void setIngre(String ingre) {
        this.ingre = ingre;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }






}