package com.example.forestofcafe;

public class Profile_MyComment_Item {
    public String getPostWriter() {
        return postWriter;
    }

    public void setPostWriter(String postWriter) {
        this.postWriter = postWriter;
    }

    public String getCafeName() {
        return cafeName;
    }

    public void setCafeName(String cafeName) {
        this.cafeName = cafeName;
    }

    public String getCafeLocation() {
        return cafeLocation;
    }

    public void setCafeLocation(String cafeLocation) {
        this.cafeLocation = cafeLocation;
    }

    public String getCommunityContent() {
        return communityContent;
    }

    public void setCommunityContent(String communityContent) {
        this.communityContent = communityContent;
    }

    public String getComentCotent() {
        return comentCotent;
    }

    public void setComentCotent(String comentCotent) {
        this.comentCotent = comentCotent;
    }

    public String getComentWriteTime() {
        return comentWriteTime;
    }

    public void setComentWriteTime(String comentWriteTime) {
        this.comentWriteTime = comentWriteTime;
    }

    public int getImg_post() {
        return img_post;
    }

    public void setImg_post(int img_post) {
        this.img_post = img_post;
    }

    String postWriter,cafeName,cafeLocation,communityContent,comentCotent,comentWriteTime;
    int img_post;
}
