package com.example.mcs.weatherapp.Repo;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.mcs.weatherapp.Model.WeatherModel;
import com.example.mcs.weatherapp.Model.JSONConverter;

import org.json.JSONException;
import org.json.JSONObject;

//Singleton API repo instance for entire App
public class WeatherAPI implements WeatherRepo {

    private static WeatherAPI mInstance;
    private VolleySingleton volley;

    private WeatherAPI(Context ctx){
        volley= VolleySingleton.getInstance(ctx);
    }
    //prevent deadlock and ensures singleton
    public static synchronized WeatherAPI getInstance(Context ctx) {
        if (mInstance==null) {
            mInstance = new WeatherAPI(ctx);
        }
        return mInstance;
    }


    @Override
    public LiveData<WeatherModel>  loadWeather(String zip) {

        //model will get set to this mutable data object in call back
        final MutableLiveData<WeatherModel> data = new MutableLiveData<>();

        //url for open weather map
        String server_url = "http://api.openweathermap.org/data/2.5/weather?zip="
                + zip + ",us&appid=308f8b6df2cf69a1efa3932c8ae1b899&units=imperial";

        //Set the call backs for request
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, server_url, null,
                new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //Sets data if json parsed correctly
                try {
                   data.setValue(JSONConverter.build(response));
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                //change the model for the UI to know that an error has occured
                data.setValue(new WeatherModel("ERROR"));
            }
        });
        //add the volley request to the queue
        volley.addToRequestQueue(jsonObjectRequest);
        return data;
    }
}
