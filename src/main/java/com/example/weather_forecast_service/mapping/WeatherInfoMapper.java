package com.example.weather_forecast_service.mapping;

import com.example.weather_forecast_service.dto.WeatherInformation;
import com.example.weather_forecast_service.dto.openweather.WeatherFromOpenweather;
import com.example.weather_forecast_service.dto.weatherstack.WeatherFromWeatherstack;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface WeatherInfoMapper {

    @Mapping(target = "temperature", source = "main.temp")
    @Mapping(target = "humidity", source = "main.humidity")
    WeatherInformation fromOpenweatherToWeatherInfo(WeatherFromOpenweather weather);

    @Mapping(target = "temperature", source = "current.temperature")
    @Mapping(target = "humidity", source = "current.humidity")
    WeatherInformation fromWeatherstackToWeatherInfo(WeatherFromWeatherstack weather);
}
