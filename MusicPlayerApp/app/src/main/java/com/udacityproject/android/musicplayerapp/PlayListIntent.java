package com.udacityproject.android.musicplayerapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class PlayListIntent extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_list);

        ArrayList<PlayListInfo> androidFlavors = new ArrayList<>();
        androidFlavors.add(new PlayListInfo(getString(R.string.songkind1), 1, 2, 3, 4));
        androidFlavors.add(new PlayListInfo(getString(R.string.songkind2), 2, 3, 1, 4));
        androidFlavors.add(new PlayListInfo(getString(R.string.songkind3), 3, 4, 1, 2));

        PlayListAdapter playlistAdapter = new PlayListAdapter(this, androidFlavors);

        ListView listView = findViewById(R.id.listview_play_list);
        listView.setAdapter(playlistAdapter);
    }
}
