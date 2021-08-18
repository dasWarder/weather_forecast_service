package com.example.weather_forecast_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherInformation implements Serializable {

    private Integer temperature;

    private Long humidity;
}
