package com.leonard.astroweather2.models.JSONUtils;

import android.content.Context;

import com.leonard.astroweather2.models.enums.DataNames;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class JSONFile {

    public static void saveForecastInfo (JSONArray array, Context context) {
        try {
            FileOutputStream fOut = context.openFileOutput(DataNames.FORECAST_FILE.toString(),Context.MODE_PRIVATE);
            fOut.write(array.toString().getBytes());
            fOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONArray getForecastInfo (Context context) {
        JSONArray result = null;
        try {
            FileInputStream fin = context.openFileInput(DataNames.FORECAST_FILE.toString());
            int c;
            String temp="";
            while( (c = fin.read()) != -1){
                temp = temp + Character.toString((char)c);
            }
            fin.close();
            result = new JSONArray(temp);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }

}
