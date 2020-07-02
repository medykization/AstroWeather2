package com.leonard.astroweather2.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.leonard.astroweather2.fragments.BasicInfoFragment;
import com.leonard.astroweather2.fragments.MoonFragment;
import com.leonard.astroweather2.fragments.SunFragment;

public class MyFragmentAdapter extends FragmentPagerAdapter {

    public MyFragmentAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new BasicInfoFragment();
            case 1:
                return new SunFragment();
            case 2:
                return new MoonFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
