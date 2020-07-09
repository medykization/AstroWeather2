package com.leonard.astroweather2.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.leonard.astroweather2.R;
import com.leonard.astroweather2.models.data_models.City;
import com.leonard.astroweather2.models.settings.SharedPreferencesOperations;

public class ExtendWeatherInfoFragment extends Fragment {

    private TextView wind_speed;
    private TextView wind_direction;
    private TextView humidity;
    private TextView visibility;

    public ExtendWeatherInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_extend_weather_info, container, false);

        wind_speed = view.findViewById(R.id.wind_speed);
        wind_direction = view.findViewById(R.id.wind_direction);
        humidity = view.findViewById(R.id.humidity);
        visibility = view.findViewById(R.id.visibility);

        setTexts(SharedPreferencesOperations.loadCity(this.getContext()));

        return view;
    }

    private void setTexts(City cityInfo) {
        wind_speed.setText(String.valueOf(cityInfo.getWindSpeed()));
        wind_direction.setText(String.valueOf(cityInfo.getWindDirection()));
        humidity.setText(String.valueOf(cityInfo.getHumidity())+"%");
        visibility.setText(String.valueOf(cityInfo.getVisibility())+"m");
    }

}