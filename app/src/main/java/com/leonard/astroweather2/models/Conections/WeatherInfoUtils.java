package com.leonard.astroweather2.models.Conections;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.leonard.astroweather2.models.enums.SecretData;
import com.leonard.astroweather2.models.settings.City;

import org.json.JSONException;
import org.json.JSONObject;

public class WeatherInfoUtils {


    public static City getWeatherInfo(final Context context, String cityName) {
        final City[] result = new City[1];
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=" + SecretData.valueOf("API_KEY").toString();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            result[0] = new City(response.getString("name"),
                                    response.getString("deg"),
                                    response.getString("visibility"),
                                    response.getInt("id"),
                                    response.getInt("humidity"),
                                    response.getInt("speed"),
                                    response.getInt("pressure"),
                                    response.getDouble("lon"),
                                    response.getDouble("lan"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, "Incorrect city name", Toast.LENGTH_SHORT).show();
                    }
                });
        return result[0];
    }

}
