package com.example.weather_forecast_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherInformation {

    private Integer temperature;

    private Integer humidity;
}
