package com.example.weather_forecast_service.dto.weatherstack;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties
public class WeatherFromWeatherstack implements Serializable {

    @JsonProperty("current")
    private Current current;
}
