package com.udacityproject.android.tourguideapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class VisitPlaceInfo extends AppCompatActivity {

    private String visitName;
    private int iconId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_to_visit);
    }

    public VisitPlaceInfo(String vName, int icon) {
        this.visitName = vName;
        this.iconId = icon;

    }

    public VisitPlaceInfo() {
    }

    public String getVisitName() {
        return visitName;
    }

    public int getIconId() {
        return iconId;
    }
}
