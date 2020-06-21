package com.example.forestofcafe;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;

public class MainCommunity_Item {
    private Drawable profile;
    private Drawable cafe_img;
    private String id;
    private String cafe_name;
    private String like_num;
    private String comment_num;
    private String score;
    private String review;


    public Drawable getProfile() {return profile;}
    public void setProfile(Drawable profile) {this.profile = profile;}

    public Drawable getCafe_Img() {return cafe_img;}
    public void setCafe_Img(Drawable cafe_img) {this.cafe_img = cafe_img;}

    public String getId() { return id; }
    public void setId(String id){this.id = id;}

    public String getCafe_Name() { return cafe_name; }
    public void setCafe_Name(String cafe_name){this.cafe_name = cafe_name;}

    public String getLike_Num() { return like_num; }
    public void setLike_Num(String like_num){this.like_num = like_num;}

    public String getComment_Num() { return comment_num; }
    public void setComment_Num(String comment_num){this.comment_num = comment_num;}

    public String getScore() { return score; }
    public void setScore(String score){this.score = score;}

    public String getReview() { return review; }
    public void setReview(String review){this.review = review;}


}
