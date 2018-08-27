package com.udacityproject.android.musicplayerapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class PlayListInfo extends AppCompatActivity {

    private String listName;
    private int icon1Id;
    private int icon2Id;
    private int icon3Id;
    private int icon4Id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlist_view);
    }

    public PlayListInfo(String lName, int i1, int i2, int i3, int i4) {
        this.listName = lName;
        this.icon1Id = i1;
        this.icon2Id = i2;
        this.icon3Id = i3;
        this.icon4Id = i4;

    }

    public String getListName() {
        return listName;
    }

    public int getIcon1Id() {
        return icon1Id;
    }

    public int getIcon2Id() {
        return icon2Id;
    }

    public int getIcon3Id() {
        return icon3Id;
    }

    public int getIcon4Id() {
        return icon4Id;
    }
}