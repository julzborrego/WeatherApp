package com.example.mcs.weatherapp;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProviders;

import com.example.mcs.weatherapp.Model.WeatherModel;
import com.example.mcs.weatherapp.Repo.WeatherAPI;
import com.example.mcs.weatherapp.Repo.WeatherRepo;
import com.example.mcs.weatherapp.UI.WeatherFragment;
import com.example.mcs.weatherapp.ViewModel.WeatherViewModel;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class WeatherRepoTest {
    @Test
    public void shouldSetWeatherModel() {

        //given
        WeatherModel model = new WeatherModel("Partly Cloudy", "Some rain, chance of snow with high of 39", "50", "10.9mph", "1035hps",
                "93%", "03:56am", "Houston",77095);

        //when
        model.setCity("Chicago");

        //then
        Assert.assertEquals(77095, model.getZip());
        Assert.assertNotEquals("Houston",model.getCity());
        Assert.assertEquals("Chicago",model.getCity());
    }

    @Test
    public void shouldGetRepo() {

        //given
        WeatherApp weatherApp=new WeatherApp();

        //when
        WeatherRepo repo=weatherApp.getWeatherRepo();

        //then
        Assert.assertEquals(null, repo.getWeatherModel());

    }

}