/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.udacityproject.android.musicplayerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MusicInfo extends AppCompatActivity {

    private String songName;
    private String artistName;
    private int iconId;
    public boolean playStop; // if it is true, song is playing

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_info);
    }

    public MusicInfo(String vName, String vArtist, int iconId, boolean play)
    {
        this.songName = vName;
        this.artistName = vArtist;
        this.iconId = iconId;
        this.playStop = play;
    }

    public String getSongName() {
        return songName;
    }

    public String getArtistName() {
        return artistName;
    }

    public int getIconId() {
        return iconId;
    }

    /*public boolean isPlayStop() {
        return playStop;
    }*/
}
