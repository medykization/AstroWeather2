package com.leonard.astroweather2.models.settings;

import android.content.Context;
import android.content.SharedPreferences;

import com.leonard.astroweather2.models.enums.DataNames;

import static android.content.Context.MODE_PRIVATE;

public class SharedPreferencesOperations {

    public static void updateSharedPreferences(Data data, Context context) {
        SharedPreferences.Editor editor = context.getSharedPreferences(DataNames.SETTINGS.toString(),Context.MODE_PRIVATE).edit();
        editor.putInt( DataNames.DELAY.toString() , data.getDelay());
        editor.apply();
    }

    public static void updateSharedPreferences(City city, Context context) {
        SharedPreferences.Editor editor = context.getSharedPreferences(DataNames.SETTINGS.toString(),Context.MODE_PRIVATE).edit();
        editor.putString( DataNames.LONGITUDE.toString() , city.getLongitude());
        editor.putString( DataNames.LATITUDE.toString() , city.getLatitude());
        editor.putString( DataNames.CITY_NAME.toString() , city.getName());
        editor.putInt(DataNames.CITY_ID.toString() , city.getId());
        editor.putInt(DataNames.WIND_DIRECTION.toString() , city.getWindDirection());
        editor.putInt(DataNames.VISIBILITY.toString() , city.getVisibility());
        editor.putInt(DataNames.HUMIDITY.toString() , city.getHumidity());
        editor.putInt(DataNames.PRESSURE.toString() , city.getPressure());
        editor.putFloat(DataNames.WIND_SPEED.toString() ,(float) city.getWindSpeed());
        editor.apply();
    }

    public static Data loadData(Context context) {
        Data result = new Data();
        SharedPreferences sharedPreferences = context.getSharedPreferences(DataNames.SETTINGS.toString(), MODE_PRIVATE);
        result.setLongitude(sharedPreferences.getString(DataNames.LONGITUDE.toString(), "19.8286"));
        result.setLatitude(sharedPreferences.getString(DataNames.LATITUDE.toString(), "51.5008"));
        result.setName(sharedPreferences.getString(DataNames.CITY_NAME.toString(), "Łódź"));
        result.setDelay(sharedPreferences.getInt(DataNames.DELAY.toString(), 2));
        return result;
    }

    public static City loadCity(Context context) {
        City result = new City();
        SharedPreferences sharedPreferences = context.getSharedPreferences(DataNames.SETTINGS.toString(), MODE_PRIVATE);
        result.setLongitude(sharedPreferences.getString(DataNames.LONGITUDE.toString(), "19.47"));
        result.setLatitude(sharedPreferences.getString(DataNames.LATITUDE.toString(), "51.75"));
        result.setName(sharedPreferences.getString(DataNames.CITY_NAME.toString(), "Lodz"));
        result.setId(sharedPreferences.getInt(DataNames.CITY_ID.toString(), 3093133));
        result.setWindSpeed(sharedPreferences.getFloat(DataNames.WIND_SPEED.toString(), 2.6F));
        result.setWindDirection(sharedPreferences.getInt(DataNames.WIND_DIRECTION.toString(), 270));
        result.setVisibility(sharedPreferences.getInt(DataNames.VISIBILITY.toString(), 10000));
        result.setHumidity(sharedPreferences.getInt(DataNames.HUMIDITY.toString(), 72));
        result.setPressure(sharedPreferences.getInt(DataNames.PRESSURE.toString(), 1011));
        return result;
    }

}
