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
        androidFlavors.add(new MusicInfo("Let Her Go", "Passenger", 2, false));
        androidFlavors.add(new MusicInfo("Sensiz Ben", "Pera", 1, false));
        androidFlavors.add(new MusicInfo("Üsküdara Giderken", "Katibim", 0, false));

        SongAdapter songAdapter = new SongAdapter(this, androidFlavors);

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = findViewById(R.id.listview_last_listened);
        listView.setAdapter(songAdapter);

    }
}
