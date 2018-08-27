package com.udacityproject.android.tourguideapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class FragmentTwo extends android.support.v4.app.Fragment {

    public FragmentTwo() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_two, container, false);

        ArrayList<VisitPlaceInfo> androidFlavors = new ArrayList<>();
        androidFlavors.add(new VisitPlaceInfo(getString(R.string.dogu_karadeniz), 9));
        androidFlavors.add(new VisitPlaceInfo(getString(R.string.ferah_pide), 10));
        androidFlavors.add(new VisitPlaceInfo(getString(R.string.haci_bekir), 11));
        androidFlavors.add(new VisitPlaceInfo(getString(R.string.meatball), 12));
        androidFlavors.add(new VisitPlaceInfo(getString(R.string.pizza), 13));
        androidFlavors.add(new VisitPlaceInfo(getString(R.string.uysal_family_rest), 14));

        VisitPlaceAdapter visitAdapter = new VisitPlaceAdapter(getActivity(), androidFlavors);

        ListView listView = rootView.findViewById(R.id.listview_flavor_two);
        listView.setAdapter(visitAdapter);

        return rootView;
    }
}
