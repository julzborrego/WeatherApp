package com.example.mcs.weatherapp.Repo;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.example.mcs.weatherapp.Model.WeatherModel;

/***
 * Repo needs to load the weathermodel
 */
public interface WeatherRepo {
    public LiveData<WeatherModel> loadWeather(String zip);
}
