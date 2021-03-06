package com.leonard.astroweather2.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.leonard.astroweather2.fragments.BasicInfoFragment;
import com.leonard.astroweather2.fragments.ExtendWeatherInfoFragment;
import com.leonard.astroweather2.fragments.MoonFragment;
import com.leonard.astroweather2.fragments.SunFragment;
import com.leonard.astroweather2.fragments.WeatherForecastFragment;

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
            case 3:
                return new ExtendWeatherInfoFragment();
            case 4:
                return new WeatherForecastFragment();
            default:
                return null;
        }
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }

    @Override
    public int getCount() {
        return 5;
    }
}
