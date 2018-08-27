package com.udacityproject.android.tourguideapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class FragmentFour extends android.support.v4.app.Fragment {

    public FragmentFour() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_four, container, false);

        ArrayList<PlanInfo> androidFlavors = new ArrayList<>();
        androidFlavors.add(new PlanInfo(getString(R.string.discover), 1, getString(R.string.money1)));
        androidFlavors.add(new PlanInfo(getString(R.string.see_around), 2, getString(R.string.money2)));
        androidFlavors.add(new PlanInfo(getString(R.string.eat_local), 3, getString(R.string.money2)));
        androidFlavors.add(new PlanInfo(getString(R.string.paragliding), 4, getString(R.string.unknown_money)));
        androidFlavors.add(new PlanInfo(getString(R.string.camp), 5, getString(R.string.unknown_money)));
        androidFlavors.add(new PlanInfo(getString(R.string.get_carpet), 6, getString(R.string.unknown_money)));
        androidFlavors.add(new PlanInfo(getString(R.string.buy_rose), 7, getString(R.string.money3)));


        PlanAdapter visitAdapter = new PlanAdapter(getActivity(), androidFlavors);

        ListView listView = rootView.findViewById(R.id.listview_flavor_four);
        listView.setAdapter(visitAdapter);

        return rootView;
    }
}
