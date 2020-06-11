package com.example.forestofcafe;

import android.graphics.drawable.Drawable;

public class FavoriteCafe_Item {
    private Drawable cafe_image;
    String cafe_name,cafe_location, cafe_number, cafe_notice, cafe_open_close;


    public void setCafe_image(Drawable cafe_image) {
        this.cafe_image = cafe_image;
    }

    public Drawable getCafe_image(){
        return cafe_image;
    }

    public void setCafe_name(String cafe_name) {
        this.cafe_name = cafe_name;
    }

    public String getCafe_name(){
        return cafe_name;
    }

    public void setCafe_location(String cafe_location) {
        this.cafe_location = cafe_location;
    }

    public String getCafe_location(){

        return cafe_location;
    }

    public void setCafe_number(String cafe_number) {
        this.cafe_number = cafe_number;
    }

    public String getCafe_number(){
        return cafe_number;
    }

    public void setCafe_notice(String cafe_notice) {
        this.cafe_notice = cafe_notice;
    }

    public String getCafe_notice(){
        return cafe_notice;
    }

    public void setCafe_open_close(String cafe_open_close) {
        this.cafe_open_close = cafe_open_close;
    }

    public String getCafe_open_close(){
        return cafe_open_close;
    }


}