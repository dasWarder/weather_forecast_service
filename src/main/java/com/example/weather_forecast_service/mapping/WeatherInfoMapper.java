package com.example.weather_forecast_service.mapping;

import com.example.weather_forecast_service.dto.WeatherInformation;
import com.example.weather_forecast_service.dto.openweather.CityInfo;
import com.example.weather_forecast_service.dto.openweather.WeatherFromOpenweather;
import com.example.weather_forecast_service.dto.weatherstack.WeatherFromWeatherstack;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface WeatherInfoMapper {

    @Mapping(target = "temperature", source = "cityInfo.main.temp")
    @Mapping(target = "humidity", source = "cityInfo.main.humidity")
    WeatherInformation fromOpenweatherToWeatherInfo(CityInfo cityInfo);

    @Mapping(target = "temperature", source = "current.temperature")
    @Mapping(target = "humidity", source = "current.humidity")
    WeatherInformation fromWeatherstackToWeatherInfo(WeatherFromWeatherstack weather);
}
