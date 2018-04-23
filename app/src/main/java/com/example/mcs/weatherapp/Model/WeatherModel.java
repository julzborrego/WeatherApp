package com.example.mcs.weatherapp.Model;

/***
 * Standard pojo to model the weather
 */
public class WeatherModel {

    private static final String TAG = "WeatherModel";

    private String overview;
    private String description;
    private String temp;
    private String windSpeed;
    private String pressure;
    private String humidity;
    private String sunrise;
    private String city;

    public WeatherModel(String overview) {
        this.overview = overview;
    }

    public WeatherModel(String overview, String description, String temp, String windSpeed,
                        String pressure, String humidity, String sunrise, String city) {
        this.overview = overview;
        this.description = description;
        this.temp = temp;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
        this.humidity = humidity;
        this.sunrise = sunrise;
        this.city = city;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
