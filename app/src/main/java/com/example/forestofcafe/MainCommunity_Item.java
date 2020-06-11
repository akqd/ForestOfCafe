package com.example.forestofcafe;

public class MainCommunity_Item {
    private int profile, cafe_image;
    String writer_name, cafe_name, cafe_review, score_num, comment_num, like_num;

    public MainCommunity_Item(int profile, int cafe_image, String writer_name, String cafe_name, String cafe_review, String score_num, String comment_num, String like_num){
        this.profile = profile;
        this.cafe_image = cafe_image;
        this.writer_name = writer_name;
        this.cafe_name = cafe_name;
        this.cafe_review = cafe_review;
        this.score_num = score_num;
        this.comment_num = comment_num;
        this.like_num = like_num;
    }

    public int getProfile(){
        return profile;
    }

    public int getCafe_image(){
        return cafe_image;
    }

    public String getWriter_name(){
        return writer_name;
    }

    public String getCafe_name(){
        return cafe_name;
    }

    public String getCafe_review(){
        return cafe_review;
    }

    public String getScore_num(){
        return score_num;
    }

    public String getComment_num(){
        return comment_num;
    }

    public String getLike_num(){
        return like_num;
    }
}
