package com.leonard.astroweather2.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.astrocalculator.AstroCalculator;
import com.leonard.astroweather2.R;
import com.leonard.astroweather2.models.astro_info.Info;
import com.leonard.astroweather2.models.data_models.City;
import com.leonard.astroweather2.models.settings.SharedPreferencesOperations;


public class SunFragment extends Fragment {

    private TextView sunrise_azim;
    private TextView sunrise_time;
    private TextView sunset_azim;
    private TextView sunset_time;
    private TextView twilight_time;
    private TextView dawn_time;

    public SunFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sun, container, false);

        sunrise_azim = view.findViewById(R.id.sunrise_Azim);
        sunrise_time = view.findViewById(R.id.sunrise_time);
        sunset_azim = view.findViewById(R.id.sunset_Azim);
        sunset_time = view.findViewById(R.id.sunset_time);
        twilight_time = view.findViewById(R.id.twilight_time);
        dawn_time = view.findViewById(R.id.dawn_time);

        City cityInfo  = SharedPreferencesOperations.loadCity(this.getContext());
        Info info = new Info(cityInfo.getLongitude(),cityInfo.getLatitude());
        setText(info.getSunInfo());
        refreshData(info, cityInfo.getDelay());

        return view;
    }

    private void refreshData(final Info info, int delay) {
        final int time = delay*1000*60;
        final Handler sunHandler = new Handler();
        sunHandler.postDelayed(new Runnable() {
            AstroCalculator.SunInfo sunInfo = info.getSunInfo();
            @Override
            public void run() {
                setText(sunInfo);
                sunHandler.postDelayed(this,time);
            }
        },time);
    }

    private void setText(AstroCalculator.SunInfo sunInfo) {
        sunrise_time.setText(sunInfo.getSunrise().getHour() +":"+ sunInfo.getSunrise().getMinute() +":"+ sunInfo.getSunrise().getSecond());
        sunset_time.setText(sunInfo.getSunset().getHour() +":"+ sunInfo.getSunset().getMinute() +":"+ sunInfo.getSunset().getSecond());
        sunrise_azim.setText(Double.toString(sunInfo.getAzimuthRise()));
        sunset_azim.setText(Double.toString(sunInfo.getAzimuthSet()));
        twilight_time.setText(sunInfo.getTwilightEvening().getHour() +":"+ sunInfo.getTwilightEvening().getMinute() +":"+ sunInfo.getTwilightEvening().getSecond());
        dawn_time.setText(sunInfo.getTwilightMorning().getHour() +":"+ sunInfo.getTwilightMorning().getMinute() +":"+ sunInfo.getTwilightMorning().getSecond());
    }

}
