package com.udacityproject.android.musicplayerapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ArrayList<MusicInfo> androidFlavors = new ArrayList<>();
        androidFlavors.add(new MusicInfo(getString(R.string.songname1), getString(R.string.artistname1), 1, false));
        androidFlavors.add(new MusicInfo(getString(R.string.songname2), getString(R.string.artistname2), 2, false));
        androidFlavors.add(new MusicInfo(getString(R.string.songname3), getString(R.string.artistname3), 0, false));

        SongAdapter songAdapter = new SongAdapter(this, androidFlavors);

        ListView listView = findViewById(R.id.listview_flavor);
        listView.setAdapter(songAdapter);

        TextView songs = findViewById(R.id.song);

        songs.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent songsIntent = new Intent(MainActivity.this, SongIntent.class);
                startActivity(songsIntent);
            }
        });

        TextView list = findViewById(R.id.list);

        list.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listIntent = new Intent(MainActivity.this, PlayListIntent.class);

                startActivity(listIntent);
            }
        });

        TextView album = findViewById(R.id.album);

        album.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent albumIntent = new Intent(MainActivity.this, AlbumIntent.class);
                startActivity(albumIntent);
            }
        });

        TextView last = findViewById(R.id.last);

        last.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lastIntent = new Intent(MainActivity.this, LastListenIntent.class);

                startActivity(lastIntent);
            }
        });

    }

}
