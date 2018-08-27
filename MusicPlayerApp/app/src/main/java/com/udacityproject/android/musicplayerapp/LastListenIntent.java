package com.udacityproject.android.musicplayerapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class LastListenIntent extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.last_listened);

        ArrayList<MusicInfo> androidFlavors = new ArrayList<>();
        androidFlavors.add(new MusicInfo(getString(R.string.songname1), getString(R.string.artistname1), 2, false));
        androidFlavors.add(new MusicInfo(getString(R.string.songname2), getString(R.string.artistname2), 1, false));
        androidFlavors.add(new MusicInfo(getString(R.string.songname3), getString(R.string.artistname3), 0, false));

        SongAdapter songAdapter = new SongAdapter(this, androidFlavors);

        ListView listView = findViewById(R.id.listview_last_listened);
        listView.setAdapter(songAdapter);

    }
}
