package com.example.realkepstone.data;

public class MyReview {

    public MyReview(String title, float star, float red, String when, String content, String url) {
        this.title = title;
        this.star = star;
        this.red = red;
        this.when = when;
        this.content = content;
        Url = url;
    }

    String title;

    public MyReview() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getStar() {
        return star;
    }

    public void setStar(float star) {
        this.star = star;
    }

    public float getRed() {
        return red;
    }

    public void setRed(float red) {
        this.red = red;
    }

    public String getWhen() {
        return when;
    }

    public void setWhen(String when) {
        this.when = when;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    float star;
    float red;
    String when;
    String content;
    String Url;

}
