package com.udacityproject.android.tourguideapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class PlanInfo extends AppCompatActivity {

    private String visitName;
    private int iconId;
    private String money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plan_view);
    }

    public PlanInfo(String vName, int icon, String money) {
        this.visitName = vName;
        this.iconId = icon;
        this.money = money + "TL";

    }

    public PlanInfo() {
    }

    public String getVisitName() {
        return visitName;
    }

    public int getIconId() {
        return iconId;
    }

    public String getMoney() {
        return money;
    }
}
