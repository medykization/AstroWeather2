package com.leonard.astroweather2.models.Conections;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.leonard.astroweather2.models.enums.SecretData;
import com.leonard.astroweather2.models.data_models.City;
import com.leonard.astroweather2.models.JSONUtils.JSONFile;
import com.leonard.astroweather2.models.settings.SharedPreferencesOperations;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WeatherInfoUtils {


    public static void updateWeatherInfo(final Context context, final String cityName) {
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=" + SecretData.valueOf("API_KEY").getVal();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        City city = null;
                        try {
                            city = new City(cityName,
                                    response.getJSONObject("wind").getInt("deg"),
                                    response.getInt("visibility"),
                                    response.getInt("id"),
                                    response.getJSONObject("main").getInt("humidity"),
                                    response.getJSONObject("wind").getDouble("speed"),
                                    response.getJSONObject("main").getDouble("temp"),
                                    response.getJSONObject("main").getInt("pressure"),
                                    response.getJSONObject("coord").getString("lon"),
                                    response.getJSONObject("coord").getString("lat"));
                        } catch (JSONException e) {
                            System.out.println(e.toString());
                        }
                        System.out.println(city);
                        SharedPreferencesOperations.updateSharedPreferences(city,context);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, "Incorrect city name", Toast.LENGTH_SHORT).show();
                    }
                });

        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(jsonObjectRequest);
    }

    public static void updateWeatherForecastInfo(final Context context, final String cityName) {

        String url = "https://api.openweathermap.org/data/2.5/forecast?q=" + cityName + "&appid=" + SecretData.valueOf("API_KEY").getVal();
        final JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray result = response.getJSONArray("list");
                            System.out.println(result != null);
                            JSONFile.saveForecastInfo(result, context);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, "Incorrect city name cannot get forecast info", Toast.LENGTH_SHORT).show();
                    }
                });

        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(jsonObjectRequest);

    }

}
