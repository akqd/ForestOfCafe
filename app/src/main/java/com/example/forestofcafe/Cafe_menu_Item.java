package com.example.forestofcafe;

import android.graphics.drawable.Drawable;

public class Cafe_menu_Item {
    private Drawable menu_img;
    private String menu_name;
    private String menu_price;

    public void setMenu_img(Drawable menu_img){this.menu_img = menu_img;}
    public Drawable getMenu_img(){return menu_img;}

    public void setMenu_name(String menu_name) {this.menu_name = menu_name;}
    public String getMenu_name(){return menu_name;}

    public void setMenu_price(String menu_price) {this.menu_price = menu_price;}
    public String getMenu_price(){return menu_price;}
}
