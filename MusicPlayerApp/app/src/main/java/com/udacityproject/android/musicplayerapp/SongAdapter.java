package com.udacityproject.android.musicplayerapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<MusicInfo> {

    public SongAdapter(Activity context, ArrayList<MusicInfo> androidFlavors) {
        super(context, 0, androidFlavors);
    }

    @Override
    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.music_info, parent, false);
        }

        MusicInfo currentAndroidFlavor = getItem(position);

        TextView nameTextView = listItemView.findViewById(R.id.songname);
        nameTextView.setText(currentAndroidFlavor.getSongName());

        TextView numberTextView = listItemView.findViewById(R.id.artistname);
        numberTextView.setText(currentAndroidFlavor.getArtistName());

        ImageView iconView = listItemView.findViewById(R.id.albumpic);

        if (currentAndroidFlavor.getIconId() == 1) {
            iconView.setImageResource(R.mipmap.ic_launcher_background2);
        } else if (currentAndroidFlavor.getIconId() == 2) {
            iconView.setImageResource(R.mipmap.ic_launcher_background1);
        } else {
            iconView.setImageResource(R.mipmap.ic_launcher_music);
        }

        return listItemView;
    }
}
