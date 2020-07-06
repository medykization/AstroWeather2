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

import com.leonard.astroweather2.models.Conections.WeatherInfoUtils;
import com.leonard.astroweather2.models.enums.DataNames;
import com.leonard.astroweather2.models.settings.City;
import com.leonard.astroweather2.models.settings.Data;
import com.leonard.astroweather2.R;
import com.leonard.astroweather2.models.settings.SharedPreferencesOperations;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView1;

    private TextView textView3;

    private EditText city;
    private EditText delay;

    private Button submit;

    private Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        textView1 = findViewById(R.id.textView1);
        textView3 = findViewById(R.id.textView3);

        city = findViewById(R.id.city);
        delay = findViewById(R.id.delay);

        submit = findViewById(R.id.submit);
        submit.setOnClickListener(this);

        data = SharedPreferencesOperations.loadData(this);
        setTextOnFields(data);

    }

    private void setTextOnFields(Data data) {
        city.setText(data.getName());
        delay.setText(String.valueOf(data.getDelay()));
    }

    private void updateData(Data data) {
        data.setDelay(Integer.parseInt(delay.getText().toString()));
    }

    private boolean checkInput() {
        int delayVal;
        WeatherInfoUtils.UpdateWeatherInfo(this,city.getText().toString());
        try {
            delayVal = Integer.parseInt(delay.getText().toString());
        } catch (NumberFormatException e) {
            return false;
        }
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

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        //This is used to hide/show 'Status Bar' & 'System Bar'. Swip bar to get it as visible.
        View decorView = getWindow().getDecorView();
        if (hasFocus) {
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

}
