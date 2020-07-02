package com.leonard.astroweather2.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.leonard.astroweather2.adapters.MyFragmentAdapter;
import com.leonard.astroweather2.models.enums.DataNames;
import com.leonard.astroweather2.models.settings.Data;
import com.leonard.astroweather2.R;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private Data loadData() {
        Data result = new Data();
        SharedPreferences sharedPreferences = getSharedPreferences(DataNames.SETTINGS.toString(), MODE_PRIVATE);
        result.setLongitude(sharedPreferences.getString(DataNames.LONGITUDE.toString(), "19.8286"));
        result.setLatitude(sharedPreferences.getString(DataNames.LATITUDE.toString(), "51.5008"));
        result.setDelay(sharedPreferences.getInt(DataNames.DELAY.toString(), 2));
        return result;
    }

}
