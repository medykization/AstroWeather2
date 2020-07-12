package com.leonard.astroweather2.models.JSONUtils;

import android.content.Context;

import com.leonard.astroweather2.models.data_models.DayInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JSONParser {

    public static List<DayInfo> getForecastInfoFromJSON(Context context) {
        JSONArray array = JSONFile.getForecastInfo(context);
        List<DayInfo> daysInfo = new ArrayList<>();

        for(int i = 0; i < 45; i += 9) {
            JSONObject tmp = null;
            String cityName = null;
            try {
                tmp = array.getJSONObject(i);
                daysInfo.add(new DayInfo(cityName,
                        tmp.getString("dt_txt"),
                        tmp.getJSONArray("weather").getString(1),
                        tmp.getJSONObject("main").getDouble("temp"),
                        tmp.getJSONObject("main").getDouble("pressure"),
                        tmp.getJSONObject("main").getDouble("humidity")));
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return daysInfo;
    }

}
