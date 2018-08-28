package com.udacityproject.android.newsapp;

import android.content.AsyncTaskLoader;
import android.content.Context;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class ItemLoad extends AsyncTaskLoader<List<ItemInfo>> {

    private String url;

    ItemLoad(Context context, String url){
        super(context);
        this.url = url;
    }

    @Override
    public List<ItemInfo> loadInBackground() {
        List<ItemInfo> newsItems = new ArrayList<>();
        if(url == null){
            return null;
        }
        try {
            newsItems = Utility.getItems(url);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return newsItems;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }
}

