package com.udacityproject.android.musicplayerapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class AlbumIntent extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_view);

        System.out.print("album intent\n");
        ArrayList<AlbumInfo> androidFlavors = new ArrayList<>();
        androidFlavors.add(new AlbumInfo("Recordings", 1));
        androidFlavors.add(new AlbumInfo("Download", 2));
        androidFlavors.add(new AlbumInfo("Classical", 3));

        for(int i=0;i<androidFlavors.size();i++)
            System.out.println("album:" + androidFlavors.get(i).getArtistName()+"   "+androidFlavors.get(i).getIconId());

        AlbumAdapter albumAdapter = new AlbumAdapter(this, androidFlavors);

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = findViewById(R.id.listview_album);
        listView.setAdapter(albumAdapter);

    }
}
