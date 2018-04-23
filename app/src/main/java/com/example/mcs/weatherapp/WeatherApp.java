package com.example.mcs.weatherapp;

import android.app.Application;

import com.example.mcs.weatherapp.Repo.WeatherAPI;
import com.example.mcs.weatherapp.Repo.WeatherRepo;

/**
 * Android Application class to hold repo
 */
public class WeatherApp extends Application {

    WeatherRepo weatherRepo;
    @Override
    public void onCreate() {
        super.onCreate();
        weatherRepo= WeatherAPI.getInstance(this);
    }

    public WeatherRepo getWeatherRepo() {
        return weatherRepo;
    }

}