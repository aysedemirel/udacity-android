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

public class PlayListAdapter extends ArrayAdapter<PlayListInfo> {
   // private static final String LOG_TAG = PlayListAdapter.class.getSimpleName();

    public PlayListAdapter(Activity context, ArrayList<PlayListInfo> androidFlavors) {
        super(context, 0, androidFlavors);
    }

    @Override
    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        int icon;
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.playlist_view, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        PlayListInfo currentAndroidFlavor = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView nameTextView = listItemView.findViewById(R.id.play_list_name);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        nameTextView.setText( currentAndroidFlavor.getListName());

        // Find the TextView in the list_item.xml layout with the ID version_number
        ImageView icon1 = listItemView.findViewById(R.id.album1);
        icon = currentAndroidFlavor.getIcon1Id();
        setIcon(icon, icon1);

        ImageView icon2 = listItemView.findViewById(R.id.album2);
        icon = currentAndroidFlavor.getIcon2Id();
        setIcon(icon, icon2);

        ImageView icon3 = listItemView.findViewById(R.id.album3);
        icon = currentAndroidFlavor.getIcon3Id();
        setIcon(icon, icon3);

        ImageView icon4 = listItemView.findViewById(R.id.album4);
        icon = currentAndroidFlavor.getIcon4Id();
        setIcon(icon, icon4);

        return listItemView;
    }

    private void setIcon(int iconId, ImageView iconView) {
        if (iconId == 1) {
            iconView.setImageResource(R.drawable.background2);
        } else if (iconId == 2) {
            iconView.setImageResource(R.drawable.background1);
        } else if (iconId == 3)
            iconView.setImageResource(R.drawable.background3);
        else {
            iconView.setImageResource(R.drawable.music);
        }
    }
}