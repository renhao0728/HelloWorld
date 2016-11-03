package com.example.citru.helloworld.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by citrus on 2016/11/3.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> mFragments;
    private String[] mTabsArray;

    public ViewPagerAdapter(FragmentManager fm, List<Fragment> mFragments, String[] mTabsArray) {
        super(fm);
        this.mFragments = mFragments;
        this.mTabsArray = mTabsArray;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabsArray[position];
    }
}
