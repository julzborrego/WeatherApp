package com.example.mcs.weatherapp.Model;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

/***
 * Json parsing, returns Weather model
 */
public class JSONConverter {
    public static WeatherModel build(JSONObject jsonResponse) throws JSONException{

        String overview = jsonResponse.getJSONArray("weather").getJSONObject(0).getString("main");
        String description = jsonResponse.getJSONArray("weather").getJSONObject(0).getString("description");
        String temp = ""+jsonResponse.getJSONObject("main").getDouble("temp");
        String windspeed = jsonResponse.getJSONObject("wind").getDouble("speed")+"mph";
        String pressure = jsonResponse.getJSONObject("main").getInt("pressure")+" hpa";
        String humidity = jsonResponse.getJSONObject("main").getInt("humidity")+ "%";
        int sunrise = jsonResponse.getJSONObject("sys").getInt("sunrise");
        String city = jsonResponse.getString("name");

       String sunriseStr = new SimpleDateFormat("HH:mm")
                .format(new Date(sunrise * 1000L));

        return new WeatherModel(overview,description,temp,windspeed,pressure,humidity,sunriseStr,city);
    }
}
