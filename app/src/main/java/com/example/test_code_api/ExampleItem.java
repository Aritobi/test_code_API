package com.example.test_code_api;

public class ExampleItem {
    private String mImageUrl;
    private String mCreator ;
    private double mLikes ;
    private String mDate ;


    public ExampleItem(String imageUrl, String creator, double likes, String Date){

        mImageUrl =imageUrl;
        mCreator = creator ;
        mLikes =likes;
        mDate = Date;

    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public String getCreator() {
        return mCreator;
    }

    public double getLikeCount() {
        return mLikes;
    }

    public String getDate() { return  mDate; }
}
