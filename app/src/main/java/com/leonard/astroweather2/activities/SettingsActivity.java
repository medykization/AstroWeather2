package com.leonard.astroweather2.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.leonard.astroweather2.models.enums.DataNames;
import com.leonard.astroweather2.models.settings.Data;
import com.leonard.astroweather2.R;
import com.leonard.astroweather2.models.settings.SharedPreferencesOperations;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;

    private EditText longitude;
    private EditText latitude;
    private EditText delay;

    private Button submit;

    private Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);

        longitude = findViewById(R.id.longitude);
        latitude = findViewById(R.id.latitude);
        delay = findViewById(R.id.delay);

        submit = findViewById(R.id.submit);
        submit.setOnClickListener(this);

        data = SharedPreferencesOperations.loadData(this);
        setTextOnFields(data);

    }

    private void setTextOnFields(Data data) {
        longitude.setText(data.getLongitude());
        latitude.setText(data.getLatitude());
        delay.setText(String.valueOf(data.getDelay()));
    }

    private void updateData(Data data) {
        data.setLongitude(longitude.getText().toString());
        data.setLatitude(latitude.getText().toString());
        data.setDelay(Integer.parseInt(delay.getText().toString()));
    }

    private boolean checkInput() {
        double longVal;
        double latVal;
        int delayVal;

        try {
            longVal = Double.parseDouble(longitude.getText().toString());
            latVal = Double.parseDouble(longitude.getText().toString());
            delayVal = Integer.parseInt(delay.getText().toString());
        } catch (NumberFormatException e) {
            return false;
        }
        if(longVal < -180 || longVal > 180)
            return false;
        if(latVal < -90 || latVal > 90)
            return false;
        if(delayVal < 1)
            return false;

        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.submit:
                if(checkInput()) {
                    updateData(data);
                    SharedPreferencesOperations.updateSharedPreferences(data, this);
                    startActivity(new Intent(this, MainActivity.class));
                }
                break;
        }
    }

}
