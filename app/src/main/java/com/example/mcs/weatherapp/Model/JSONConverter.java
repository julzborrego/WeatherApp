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

        String overview = jsonResponse.optJSONArray("weather").optJSONObject(0).optString("main");
        String description = jsonResponse.optJSONArray("weather").optJSONObject(0).optString("description");
        String temp = ""+jsonResponse.optJSONObject("main").optDouble("temp");
        String windspeed = jsonResponse.optJSONObject("wind").optDouble("speed")+"mph";
        String pressure = jsonResponse.optJSONObject("main").optInt("pressure")+" hpa";
        String humidity = jsonResponse.optJSONObject("main").optInt("humidity")+ "%";
        int sunrise = jsonResponse.optJSONObject("sys").optInt("sunrise");
        String city = jsonResponse.optString("name");

       String sunriseStr = new SimpleDateFormat("HH:mm")
                .format(new Date(sunrise * 1000L));

        return new WeatherModel(overview,description,temp,windspeed,pressure,humidity,sunriseStr,city);
    }
}
