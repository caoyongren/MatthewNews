package com.matthew.matthewnews.weather.model;

import android.content.Context;

public interface WeatherModel {

    void loadWeatherData(String cityName, WeatherModelImpl.LoadWeatherListener listener);

    void loadLocation(Context context, WeatherModelImpl.LoadLocationListener listener);

}
