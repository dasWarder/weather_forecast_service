package com.example.weather_forecast_service.dto.weatherstack;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class WeatherFromWeatherstack {

    @JsonProperty("current")
    private Current current;
}
