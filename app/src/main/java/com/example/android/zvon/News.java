package com.example.android.zvon;

public class News {

    String mSection;
    String mDate;
    String mTitle;
    String mUrl;

    //construct a new News object
    public News(String Section, String Date, String Title, String Url) {
        mSection = Section;
        mDate = Date;
        mTitle = Title;
        mUrl = Url;
    }


    public String getSection() {
        return mSection;
    }

    public String getDate() {
        return mDate;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getUrl() {
        return mUrl;
    }
}
