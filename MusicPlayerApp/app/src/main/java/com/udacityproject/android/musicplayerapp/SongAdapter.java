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
   // private static final String LOG_TAG = SongAdapter.class.getSimpleName();

    public SongAdapter(Activity context, ArrayList<MusicInfo> androidFlavors) {
        super(context, 0, androidFlavors);
    }

    @Override
    @NonNull
    public View getView(int position, View convertView,@NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.music_info, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        MusicInfo currentAndroidFlavor = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView nameTextView = listItemView.findViewById(R.id.songname);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        nameTextView.setText(currentAndroidFlavor.getSongName());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView numberTextView = listItemView.findViewById(R.id.artistname);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        numberTextView.setText(currentAndroidFlavor.getArtistName());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = listItemView.findViewById(R.id.albumpic);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView

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
