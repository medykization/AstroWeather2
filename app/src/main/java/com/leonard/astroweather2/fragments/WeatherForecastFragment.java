package com.leonard.astroweather2.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.leonard.astroweather2.R;
import com.leonard.astroweather2.models.JSONUtils.JSONParser;
import com.leonard.astroweather2.models.data_models.City;
import com.leonard.astroweather2.models.data_models.DayInfo;
import com.leonard.astroweather2.models.settings.SharedPreferencesOperations;

import java.util.List;

public class WeatherForecastFragment extends Fragment {

    private ImageView first_day;
    private ImageView second_day;
    private ImageView third_day;
    private ImageView fourth_day;
    private ImageView fifth_day;

    private TextView first_day_info;
    private TextView second_day_info;
    private TextView third_day_info;
    private TextView fourth_day_info;
    private TextView fifth_day_info;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather_forecast, container, false);

        first_day = view.findViewById(R.id.first_day);
        second_day = view.findViewById(R.id.second_day);
        third_day = view.findViewById(R.id.third_day);
        fourth_day = view.findViewById(R.id.fourth_day);
        fifth_day = view.findViewById(R.id.fifth_day);

        first_day_info = view.findViewById(R.id.first_day_info);
        second_day_info = view.findViewById(R.id.second_day_info);
        third_day_info = view.findViewById(R.id.third_day_info);
        fourth_day_info = view.findViewById(R.id.fourth_day_info);
        fifth_day_info = view.findViewById(R.id.fifth_day_info);

        setUpValues();

        return view;
    }

    private void setUpValues() {
        City city = SharedPreferencesOperations.loadCity(this.getContext());
        List<DayInfo> daysInfo = JSONParser.getForecastInfoFromJSON(this.getContext(),city.getName());

        first_day.setImageResource(R.drawable.cloudy_havyrain);

        first_day_info.setText(daysInfo.get(0).getWeather());
        second_day_info.setText(daysInfo.get(1).getWeather());
        third_day_info.setText(daysInfo.get(2).getWeather());
        fourth_day_info.setText(daysInfo.get(3).getWeather());
        fifth_day_info.setText(daysInfo.get(4).getWeather());

    }
}