package com.udacityproject.android.tourguideapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class VisitPlaceAdapter extends ArrayAdapter<VisitPlaceInfo> {

    VisitPlaceAdapter(Activity context, ArrayList<VisitPlaceInfo> androidFlavors) {
        super(context, 0, androidFlavors);
    }

    @Override
    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.place_to_visit, parent, false);
        }

        VisitPlaceInfo currentAndroidFlavor = getItem(position);

        TextView nameTextView = listItemView.findViewById(R.id.place_name);
        assert currentAndroidFlavor != null;
        nameTextView.setText(currentAndroidFlavor.getVisitName());

        ImageView iconView = listItemView.findViewById(R.id.place_image);
        int iconId = currentAndroidFlavor.getIconId();
        setIcon(iconId, iconView);

        return listItemView;
    }

    private void setIcon(int iconId, ImageView iconView) {
        if (iconId == 1) {
            iconView.setImageResource(R.mipmap.ic_launcher_aksu);
        } else if (iconId == 2) {
            iconView.setImageResource(R.mipmap.ic_launcher_egirdir);
        } else if (iconId == 3)
            iconView.setImageResource(R.mipmap.ic_launcher_gonen);
        else if (iconId == 4) {
            iconView.setImageResource(R.mipmap.ic_launcher_kizildag);
        } else if (iconId == 5) {
            iconView.setImageResource(R.mipmap.ic_launcher_kovada);
        } else if (iconId == 6) {
            iconView.setImageResource(R.mipmap.ic_launcher_kuyucak);
        } else if (iconId == 7) {
            iconView.setImageResource(R.mipmap.ic_launcher_sutculer);
        } else if (iconId == 8) {
            iconView.setImageResource(R.mipmap.ic_launcher_yalvac);
        } else if (iconId == 9) {
            iconView.setImageResource(R.mipmap.ic_launcher_dogukaradeniz);
        } else if (iconId == 10) {
            iconView.setImageResource(R.mipmap.ic_launcher_ferahkebab);
        } else if (iconId == 11) {
            iconView.setImageResource(R.mipmap.ic_launcher_hacibekir);
        } else if (iconId == 12) {
            iconView.setImageResource(R.mipmap.ic_launcher_kofteciyusuf);
        } else if (iconId == 13) {
            iconView.setImageResource(R.mipmap.ic_launcher_pasaportpizza);
        } else if (iconId == 14) {
            iconView.setImageResource(R.mipmap.ic_launcher_uysalaile);
        } else if (iconId == 15) {
            iconView.setImageResource(R.mipmap.ic_launcher_fish);
        } else if (iconId == 16) {
            iconView.setImageResource(R.mipmap.ic_launcher_picnic);
        } else if (iconId == 17) {
            iconView.setImageResource(R.mipmap.ic_launcher_kebab);
        } else {
            iconView.setImageResource(R.mipmap.ic_launcher_photo);
        }


    }
}