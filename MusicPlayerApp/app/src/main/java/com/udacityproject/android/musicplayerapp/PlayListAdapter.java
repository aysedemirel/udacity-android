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

    public PlayListAdapter(Activity context, ArrayList<PlayListInfo> androidFlavors) {
        super(context, 0, androidFlavors);
    }

    @Override
    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        int icon;
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.playlist_view, parent, false);
        }

        PlayListInfo currentAndroidFlavor = getItem(position);

        TextView nameTextView = listItemView.findViewById(R.id.play_list_name);
        nameTextView.setText(currentAndroidFlavor.getListName());

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
            iconView.setImageResource(R.mipmap.ic_launcher_background1);
        } else if (iconId == 2) {
            iconView.setImageResource(R.mipmap.ic_launcher_background2);
        } else if (iconId == 3)
            iconView.setImageResource(R.mipmap.ic_launcher_background3);
        else {
            iconView.setImageResource(R.mipmap.ic_launcher_music);
        }
    }
}