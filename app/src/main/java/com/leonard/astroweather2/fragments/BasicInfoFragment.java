package com.leonard.astroweather2.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.leonard.astroweather2.R;
import com.leonard.astroweather2.models.astro_info.Info;
import com.leonard.astroweather2.models.enums.DataNames;
import com.leonard.astroweather2.models.settings.Data;
import com.leonard.astroweather2.models.settings.SharedPreferencesOperations;

import static android.content.Context.MODE_PRIVATE;

public class BasicInfoFragment extends Fragment {

    private TextView longitude;
    private TextView latitude;

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

        Data data = SharedPreferencesOperations.loadData(this.getContext());
        longitude.setText(data.getLongitude());
        latitude.setText(data.getLatitude());

        return view;
    }

}
