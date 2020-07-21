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
            FileOutputStream fOut = context.openFileOutput(DataNames.FORECAST_FILE.toString() + ".json",Context.MODE_PRIVATE);
            fOut.write(array.toString().getBytes());
            fOut.flush();
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
            FileInputStream fin = context.openFileInput(DataNames.FORECAST_FILE.toString() + ".json");
            int size = fin.available();
            byte[] buffer = new byte[size];
            fin.read(buffer);
            fin.close();
            System.out.println(new String(buffer));
            result = new JSONArray(new String(buffer));
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
