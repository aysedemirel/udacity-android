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

public class PlanAdapter extends ArrayAdapter<PlanInfo> {

    PlanAdapter(Activity context, ArrayList<PlanInfo> androidFlavors) {
        super(context, 0, androidFlavors);
    }

    @Override
    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.plan_view, parent, false);
        }

        PlanInfo currentAndroidFlavor = getItem(position);

        TextView nameTextView = listItemView.findViewById(R.id.plan_name);
        assert currentAndroidFlavor != null;
        nameTextView.setText(currentAndroidFlavor.getVisitName());

        ImageView iconView = listItemView.findViewById(R.id.plan_img);
        int iconId = currentAndroidFlavor.getIconId();
        setIcon(iconId, iconView);

        TextView moneyTextView = listItemView.findViewById(R.id.plan_total_money);
        moneyTextView.setText(currentAndroidFlavor.getMoney());

        return listItemView;
    }

    private void setIcon(int iconId, ImageView iconView) {
        if (iconId == 1) {
            iconView.setImageResource(R.mipmap.ic_launcher_kizildag);
        } else if (iconId == 2) {
            iconView.setImageResource(R.mipmap.ic_launcher_yalvac);
        } else if (iconId == 3)
            iconView.setImageResource(R.mipmap.ic_launcher_kebab);
        else if (iconId == 4) {
            iconView.setImageResource(R.mipmap.ic_launcher_yamac);
        } else if (iconId == 5) {
            iconView.setImageResource(R.mipmap.ic_launcher_kovada);
        } else if (iconId == 6) {
            iconView.setImageResource(R.mipmap.ic_launcher_carpet);
        } else if (iconId == 7) {
            iconView.setImageResource(R.mipmap.ic_launcher_roseproduct);
        } else {
            iconView.setImageResource(R.mipmap.ic_launcher_photo);
        }
    }

}
