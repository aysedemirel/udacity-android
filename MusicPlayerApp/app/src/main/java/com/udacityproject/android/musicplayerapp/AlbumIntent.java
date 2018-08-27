package com.udacityproject.android.musicplayerapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class AlbumIntent extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_view);

        ArrayList<AlbumInfo> androidFlavors = new ArrayList<>();
        androidFlavors.add(new AlbumInfo(getString(R.string.listname1), 1));
        androidFlavors.add(new AlbumInfo(getString(R.string.listname2), 2));
        androidFlavors.add(new AlbumInfo(getString(R.string.listname3), 3));

        AlbumAdapter albumAdapter = new AlbumAdapter(this, androidFlavors);

        ListView listView = findViewById(R.id.listview_album);
        listView.setAdapter(albumAdapter);

    }
}
