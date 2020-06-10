package com.example.forestofcafe;

import android.graphics.drawable.Drawable;

public class SearchResult_Item {
    public Drawable getCafe_image() {
        return cafe_image;
    }

    public void setCafe_image(Drawable cafe_image) {
        this.cafe_image = cafe_image;
    }

    private Drawable cafe_image;

    public String getCafe_title() {
        return cafe_title;
    }

    public void setCafe_title(String cafe_title) {
        this.cafe_title = cafe_title;
    }

    private String cafe_title;

    public String getCafe_keyword() {
        return cafe_keyword;
    }

    public void setCafe_keyword(String cafe_keyword) {
        this.cafe_keyword = cafe_keyword;
    }

    private String cafe_keyword;

    public String getCafe_location() {
        return cafe_location;
    }

    public void setCafe_location(String cafe_location) {
        this.cafe_location = cafe_location;
    }

    private String cafe_location;

    public String getCafe_distance() {
        return cafe_distance;
    }

    public void setCafe_distance(String cafe_distance) {
        this.cafe_distance = cafe_distance;
    }

    private String cafe_distance;

    public String getCafe_OP_CL() {
        return cafe_OP_CL;
    }

    public void setCafe_OP_CL(String cafe_OP_CL) {
        this.cafe_OP_CL = cafe_OP_CL;
    }

    private String cafe_OP_CL;
}
