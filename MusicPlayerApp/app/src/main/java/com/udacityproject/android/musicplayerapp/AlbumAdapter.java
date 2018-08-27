package com.udacityproject.android.musicplayerapp;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class AlbumAdapter extends ArrayAdapter<AlbumInfo> {
    private static final String LOG_TAG = AlbumAdapter.class.getSimpleName();

    public AlbumAdapter(@NonNull Activity context, @NonNull ArrayList<AlbumInfo> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.album_list_view, parent, false);
        }

        AlbumInfo currentAndroidFlavor = getItem(position);

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.album_title);
        nameTextView.setText(currentAndroidFlavor.getArtistName());

        ImageView iconView = (ImageView) listItemView.findViewById(R.id.album1);

        if (currentAndroidFlavor.getIconId() == 1) {
            iconView.setImageResource(R.mipmap.ic_launcher_background1);
        } else if (currentAndroidFlavor.getIconId() == 2) {
            iconView.setImageResource(R.mipmap.ic_launcher_background2);
        } else {
            iconView.setImageResource(R.mipmap.ic_launcher_music);
        }
        return listItemView;
    }
}