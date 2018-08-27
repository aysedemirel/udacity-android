package com.udacityproject.android.musicplayerapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class AlbumInfo extends AppCompatActivity {

    private String artistName;
    private int iconId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_list_view);
    }

    public AlbumInfo(String aName, int iconId) {
        this.artistName = aName;
        this.iconId = iconId;
    }

    public String getArtistName() {
        return artistName;
    }

    public int getIconId() {
        return iconId;
    }
}
