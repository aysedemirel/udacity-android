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
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.album_list_view, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        AlbumInfo currentAndroidFlavor = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.album_title);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        nameTextView.setText(currentAndroidFlavor.getArtistName());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.album1);

        if(currentAndroidFlavor.getIconId() == 1) {
            iconView.setImageResource(R.drawable.background2);
        }
        else if(currentAndroidFlavor.getIconId() == 2)
        {
            iconView.setImageResource(R.drawable.background1);
        }
        else {
            iconView.setImageResource(R.drawable.music);
        }
        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
        }
}