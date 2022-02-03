package com.zybooks.thebanddatabase.Model;

public class Band {
    private int mId;
    private String mName;
    private String mDescription;
    private String mImg;
    private String mLink;

    public Band() {}

    public Band(int id, String name, String description, String img, String link) {
        mId = id;
        mName = name;
        mDescription = description;
        mImg = img;
        mLink = link;
    }

    public int getId() {
        return mId;
    }
    public void setId(int id) {
        this.mId = id;
    }

    public String getName() {
        return mName;
    }
    public void setName(String name) {
        this.mName = name;
    }

    public String getDescription() {
        return mDescription;
    }
    public void setDescription(String description) {
        this.mDescription = description;
    }

    public String getImg() {
        return mImg;
    }
    public void setImg(String img) {
        this.mImg = img;
    }

    public String getLink(){return mLink;}
    public void setLink(String link){ mLink = link;}
}