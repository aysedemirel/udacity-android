package com.udacityproject.android.tourguideapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {


    private int[] tabIcons = {R.mipmap.ic_launcher_explore, R.mipmap.ic_launcher_restaurant, R.mipmap.ic_launcher_activity, R.mipmap.ic_launcher_plan};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);

    }


    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentOne(), getString(R.string.explore));
        adapter.addFragment(new FragmentTwo(), getString(R.string.restaurants));
        adapter.addFragment(new FragmentThree(), getString(R.string.activities));
        adapter.addFragment(new FragmentFour(), getString(R.string.rec_plan));
        viewPager.setAdapter(adapter);
    }
}
