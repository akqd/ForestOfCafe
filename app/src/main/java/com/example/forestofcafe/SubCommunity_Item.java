package com.example.forestofcafe;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class SubCommunity_Item {

    private Drawable cafe_img;
    private Drawable writer_profile;
    private String writer_id;
    private String cafe_name;
    private String cafe_address;
    private String review;
    private String comment_num;
    private String like_num;
    private Float star_num;
    private String[] hashtag;

    public Drawable getCafe_Img() {return cafe_img;}
    public void setCafe_Img(Drawable cafe_img) {this.cafe_img = cafe_img;}

    public Drawable getWriter_Profile() {return writer_profile;}
    public void setWriter_Profile(Drawable writer_profile) {this.writer_profile = writer_profile;}

    public String getWriter_Id() { return writer_id; }
    public void setWriter_Id(String writer_id){this.writer_id = writer_id;}

    public String getCafe_Name() { return cafe_name; }
    public void setCafe_Name(String cafe_name){this.cafe_name = cafe_name;}

    public String getCafe_Address() { return cafe_address; }
    public void setCafe_Address(String cafe_address){this.cafe_address = cafe_address;}

    public String getReview() { return review; }
    public void setReview(String review){this.review = review;}

    public String getComment_Num() { return comment_num; }
    public void setComment_Num(String comment_num){this.comment_num = comment_num;}

    public String getLike_Num() { return like_num; }
    public void setLike_Num(String like_num){this.like_num = like_num;}

    public Float getStar_num() { return star_num; }
    public void setStar_num(Float star_num){this.star_num = star_num;}

    public String[] getHashtag() { return hashtag; }
    public void setHashtag(String[] hashtag) {this.hashtag = hashtag;}
}
