package com.leonard.astroweather2.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.leonard.astroweather2.R;
import com.leonard.astroweather2.models.settings.Data;
import com.leonard.astroweather2.models.settings.SharedPreferencesOperations;

public class BasicInfoFragment extends Fragment {

    private TextView longitude;
    private TextView latitude;
    private TextView city;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_basic_info, container, false);
        longitude = view.findViewById(R.id.longitudeInfo);
        latitude = view.findViewById(R.id.latitudeInfo);
        city = view.findViewById(R.id.city);
        setTexts();
        return view;
    }

    private void setTexts() {
        Data data = SharedPreferencesOperations.loadData(this.getContext());
        System.out.println(data.toString());
        longitude.setText(data.getLongitude());
        latitude.setText(data.getLatitude());
        city.setText(data.getName());
    }

}
