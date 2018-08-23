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
        androidFlavors.add(new MusicInfo("Let Her Go", "Passenger", 1, false));
        androidFlavors.add(new MusicInfo("Sensiz Ben", "Pera", 2, false));
        androidFlavors.add(new MusicInfo("Üsküdara Giderken", "Katibim", 0, false));

        SongAdapter songAdapter = new SongAdapter(this, androidFlavors);

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = findViewById(R.id.listview_flavor);
        listView.setAdapter(songAdapter);


        // open in a new screen
        TextView songs = findViewById(R.id.song);

        // Set a click listener on that View
        songs.setOnClickListener(new OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent songsIntent = new Intent(MainActivity.this, SongIntent.class);

                // Start the new activity
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
                System.out.println("album arası");
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

       /* TextView artist = findViewById(R.id.artist);

        artist.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent artistIntent = new Intent(MainActivity.this, ArtistIntent.class);

                startActivity(artistIntent);
            }
        });*/

    }

}
