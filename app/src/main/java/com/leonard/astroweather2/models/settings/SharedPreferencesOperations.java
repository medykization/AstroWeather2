package com.leonard.astroweather2.models.settings;

import android.content.Context;
import android.content.SharedPreferences;

import com.leonard.astroweather2.models.enums.DataNames;

import static android.content.Context.MODE_PRIVATE;

public class SharedPreferencesOperations {

    public static void updateSharedPreferences(Data data, Context context) {
        SharedPreferences.Editor editor = context.getSharedPreferences(DataNames.SETTINGS.toString(),Context.MODE_PRIVATE).edit();
        editor.putString( DataNames.LONGITUDE.toString() , data.getLongitude());
        editor.putString( DataNames.LATITUDE.toString() , data.getLatitude());
        editor.putInt( DataNames.DELAY.toString() , data.getDelay());
        editor.apply();
    }

    public static Data loadData(Context context) {
        Data result = new Data();
        SharedPreferences sharedPreferences = context.getSharedPreferences(DataNames.SETTINGS.toString(), MODE_PRIVATE);
        result.setLongitude(sharedPreferences.getString(DataNames.LONGITUDE.toString(), "19.8286"));
        result.setLatitude(sharedPreferences.getString(DataNames.LATITUDE.toString(), "51.5008"));
        result.setDelay(sharedPreferences.getInt(DataNames.DELAY.toString(), 2));
        return result;
    }

}
