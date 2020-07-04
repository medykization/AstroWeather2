package com.leonard.astroweather2.fragments;

import android.content.SharedPreferences;
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
import com.leonard.astroweather2.models.enums.DataNames;
import com.leonard.astroweather2.models.settings.Data;
import com.leonard.astroweather2.models.settings.SharedPreferencesOperations;

import static android.content.Context.MODE_PRIVATE;


public class MoonFragment extends Fragment {
    private TextView moonrise_time;
    private TextView moonset_time;
    private TextView full_moon;
    private TextView moon_new;
    private TextView phase;
    private TextView synodic_month_day;

    public MoonFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_moon, container, false);

        moonrise_time = view.findViewById(R.id.moonrise_time);
        moonset_time = view.findViewById(R.id.moonset_time);
        full_moon = view.findViewById(R.id.full_moon);
        moon_new = view.findViewById(R.id.moon_new);
        phase = view.findViewById(R.id.phase);
        synodic_month_day = view.findViewById(R.id.synodic_month_day);

        Data data  = SharedPreferencesOperations.loadData(this.getContext());
        Info info = new Info(data.getLongitude(),data.getLatitude());
        setText(info.getMoonInfo());
        refreshData(info, data.getDelay());

        return view;
    }

    private void refreshData(final Info info, int delay) {
        final int time = delay*1000*60;
        final Handler moonHandler = new Handler();
        moonHandler.postDelayed(new Runnable() {
            AstroCalculator.MoonInfo moonInfo = info.getMoonInfo();
            @Override
            public void run() {
                setText(moonInfo);
                moonHandler.postDelayed(this,time);
            }
        },time);
    }

    private void setText(AstroCalculator.MoonInfo moonInfo) {
        moonrise_time.setText(moonInfo.getMoonrise().getHour() +":"+ moonInfo.getMoonrise().getMinute() +":"+ moonInfo.getMoonrise().getSecond());
        moonset_time.setText(moonInfo.getMoonset().getHour() +":"+ moonInfo.getMoonset().getMinute() +":"+ moonInfo.getMoonset().getSecond());
        full_moon.setText(moonInfo.getNextFullMoon().getDay() +"."+ moonInfo.getNextFullMoon().getMonth() +"."+ moonInfo.getNextFullMoon().getYear());
        moon_new.setText(moonInfo.getNextNewMoon().getDay() +"."+ moonInfo.getNextNewMoon().getMonth() +"."+ moonInfo.getNextNewMoon().getYear());
        phase.setText(String.valueOf(moonInfo.getAge()));
        synodic_month_day.setText(String.valueOf(moonInfo.getIllumination()*100));
    }

}
