package com.udacityproject.android.tourguideapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class FragmentOne extends android.support.v4.app.Fragment {

    public FragmentOne() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_one, container, false);

        ArrayList<VisitPlaceInfo> androidFlavors = new ArrayList<>();
        androidFlavors.add(new VisitPlaceInfo(getString(R.string.cave), 1));
        androidFlavors.add(new VisitPlaceInfo(getString(R.string.egirdir), 2));
        androidFlavors.add(new VisitPlaceInfo(getString(R.string.rose_gardens), 3));
        androidFlavors.add(new VisitPlaceInfo(getString(R.string.kizildag), 4));
        androidFlavors.add(new VisitPlaceInfo(getString(R.string.kovada), 5));
        androidFlavors.add(new VisitPlaceInfo(getString(R.string.lavender_garden), 6));
        androidFlavors.add(new VisitPlaceInfo(getString(R.string.canyon), 7));
        androidFlavors.add(new VisitPlaceInfo(getString(R.string.ancient_city), 8));


        VisitPlaceAdapter visitAdapter = new VisitPlaceAdapter(getActivity(), androidFlavors);

        ListView listView = rootView.findViewById(R.id.listview_flavor);
        listView.setAdapter(visitAdapter);

        return rootView;
    }
}
