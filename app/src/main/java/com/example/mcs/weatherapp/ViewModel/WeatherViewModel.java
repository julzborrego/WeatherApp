package com.example.mcs.weatherapp.ViewModel;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.Nullable;

import com.example.mcs.weatherapp.Model.WeatherModel;
import com.example.mcs.weatherapp.WeatherApp;

public class WeatherViewModel extends ViewModel {

    //There Observed data field
    private LiveData<WeatherModel> weatherModel;


    public void init(String zip, Application app) {
        //Only runs once for each fragment instance
        if(weatherModel!=null){
            return;
        }

        //sets the original value to a banck weather model
        final MutableLiveData<WeatherModel> data = new MutableLiveData<>();
        data.setValue(new WeatherModel("","","","","","","",""));
        weatherModel=data;

        //loads the model from the repo
        weatherModel = ((WeatherApp)app).getWeatherRepo().loadWeather(zip);

    }

    //Accesor for the weather model to be observed
    public LiveData<WeatherModel> getWeatherModel() {
        return this.weatherModel;
    }

}
