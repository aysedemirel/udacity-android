package com.udacityproject.android.tourguideapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class FragmentThree extends android.support.v4.app.Fragment {

    public FragmentThree() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragement_three, container, false);

        ArrayList<VisitPlaceInfo> androidFlavors = new ArrayList<>();
        androidFlavors.add(new VisitPlaceInfo(getString(R.string.collect_rose), 3));
        androidFlavors.add(new VisitPlaceInfo(getString(R.string.eat_fish), 15));
        androidFlavors.add(new VisitPlaceInfo(getString(R.string.eat_local_food), 17));
        androidFlavors.add(new VisitPlaceInfo(getString(R.string.make_picnic), 16));

        VisitPlaceAdapter visitAdapter = new VisitPlaceAdapter(getActivity(), androidFlavors);

        ListView listView = rootView.findViewById(R.id.listview_flavor_three);
        listView.setAdapter(visitAdapter);

        return rootView;
    }
}
