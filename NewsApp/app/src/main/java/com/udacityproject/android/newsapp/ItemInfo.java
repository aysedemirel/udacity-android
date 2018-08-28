package com.udacityproject.android.newsapp;

public class ItemInfo {

    private String newsTitle;
    private String date;
    private String section;
    private String url;
    private String authorName;

    ItemInfo(String newsItem, String date, String section, String url, String authorName) {
        this.newsTitle = newsItem;
        this.date = date;
        this.section = section;
        this.url = url;
        this.authorName = authorName;
    }

    public String getAuthorName() {
        return authorName;
    }

    String getNewsTitle() {
        return newsTitle;
    }

    String getDate() {
        return date;
    }

    String getSection() {
        return section;
    }

    String getUrl() {
        return url;
    }
}
