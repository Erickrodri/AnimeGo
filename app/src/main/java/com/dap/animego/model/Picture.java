package com.dap.animego.model;

public class Picture {
    private String picture;
    private String title;
    private String chapter;

    public Picture(String picture, String title, String chapter) {
        this.picture = picture;
        this.title = title;
        this.chapter = chapter;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }
}
