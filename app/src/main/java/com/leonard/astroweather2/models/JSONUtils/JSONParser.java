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
        List<DayInfo> dayInfos = new ArrayList<>();

        for(int i = 0; i < 45; i += 9) {
            JSONObject tmp = null;
            try {
                tmp = array.getJSONObject(i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            dayInfos.add(new DayInfo());

        }
        return dayInfos;
    }

}
