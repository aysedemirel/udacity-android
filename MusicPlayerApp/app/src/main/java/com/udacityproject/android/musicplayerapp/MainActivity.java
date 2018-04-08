package com.udacityproject.android.musicplayerapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.udacityproject.android.musicplayerapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        TextView pop = (TextView) findViewById(R.id.pop);

        pop.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent popIntent = new Intent(MainActivity.this, MusicInfo.class);

                startActivity(popIntent);
            }
        });
    }
    public void openNumberList(View view)
    {
        Intent intent=new Intent(this,MusicInfo.class);
        startActivity(intent);
    }
}
