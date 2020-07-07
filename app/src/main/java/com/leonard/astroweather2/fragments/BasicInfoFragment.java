package com.leonard.astroweather2.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextClock;
import android.widget.TextView;

import com.leonard.astroweather2.R;
import com.leonard.astroweather2.models.settings.City;
import com.leonard.astroweather2.models.settings.SharedPreferencesOperations;

public class BasicInfoFragment extends Fragment {

    private TextView longitude;
    private TextView latitude;
    private TextView city;
    private TextView temp;
    private TextView pressure;
    private TextClock textClock;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_basic_info, container, false);
        //textClock = view.findViewById(R.id.clock);
        longitude = view.findViewById(R.id.longitudeInfo);
        latitude = view.findViewById(R.id.latitudeInfo);
        city = view.findViewById(R.id.city);
        temp = view.findViewById(R.id.temp);
        pressure = view.findViewById(R.id.pressure);
        setTexts();
        return view;
    }

    private void setTexts() {
        City cityInfo = SharedPreferencesOperations.loadCity(this.getContext());
        longitude.setText(cityInfo.getLongitude());
        latitude.setText(cityInfo.getLatitude());
        city.setText(cityInfo.getName());
    }

}
