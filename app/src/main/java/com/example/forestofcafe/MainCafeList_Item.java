package com.example.forestofcafe;

import android.graphics.drawable.Drawable;

public class MainCafeList_Item {



    public String getCafe_Name() { return cafe_name; }

    public void setCafe_Name(String cafe_name) {
        this.cafe_name = cafe_name;
    }

    private String cafe_name;

    public String getCafe_openclose() {
        return cafe_openclose;
    }

    public void setCafe_openclose(String cafe_openclose) {
        this.cafe_openclose = cafe_openclose;
    }

    private String cafe_openclose;

    public String getCafe_distance() {
        return cafe_distance;
    }

    public void setCafe_distance(String cafe_distance) {
        this.cafe_distance = cafe_distance;
    }

    private String cafe_distance;

    public Drawable getCafe_Image() {
        return cafe_image;
    }

    public void setCafe_Image(Drawable cafe_image) {
        this.cafe_image = cafe_image;
    }

    private Drawable cafe_image;

}
