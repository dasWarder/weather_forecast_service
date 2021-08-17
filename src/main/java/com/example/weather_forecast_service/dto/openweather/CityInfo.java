package com.example.weather_forecast_service.dto.openweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class CityInfo {

    @JsonProperty("main")
    private Main main;
}
