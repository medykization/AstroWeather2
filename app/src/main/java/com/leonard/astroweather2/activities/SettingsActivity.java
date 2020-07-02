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

        data = loadData();
        setTextOnFields(data);

    }

    public void setTextOnFields(Data data) {
        longitude.setText(data.getLongitude());
        latitude.setText(data.getLatitude());
        delay.setText(String.valueOf(data.getDelay()));
    }

    public Data loadData() {
        Data result = new Data();
        SharedPreferences sharedPreferences = getSharedPreferences(DataNames.SETTINGS.toString(), MODE_PRIVATE);
        result.setLongitude(sharedPreferences.getString(DataNames.LONGITUDE.toString(), "19.8286"));
        result.setLatitude(sharedPreferences.getString(DataNames.LATITUDE.toString(), "51.5008"));
        result.setDelay(sharedPreferences.getInt(DataNames.DELAY.toString(), 2));
        return result;
    }

    private void updateSharedPreferences(Data data) {
        SharedPreferences.Editor editor = getSharedPreferences(DataNames.SETTINGS.toString(),Context.MODE_PRIVATE).edit();
        editor.putString( DataNames.LONGITUDE.toString() , data.getLongitude());
        editor.putString( DataNames.LATITUDE.toString() , data.getLatitude());
        editor.putInt( DataNames.DELAY.toString() , data.getDelay());
        editor.apply();
    }

    private void updateData(Data data) {
        data.setLongitude(longitude.getText().toString());
        data.setLatitude(latitude.getText().toString());
        data.setDelay(Integer.parseInt(delay.getText().toString()));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.submit:
                updateData(data);
                updateSharedPreferences(data);
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }

}
