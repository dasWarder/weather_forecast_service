package com.example.weather_forecast_service.service;

import com.example.weather_forecast_service.dto.WeatherInformation;

public interface WeatherService {

    WeatherInformation getCurrentData(String requestUri) throws Throwable;
}
