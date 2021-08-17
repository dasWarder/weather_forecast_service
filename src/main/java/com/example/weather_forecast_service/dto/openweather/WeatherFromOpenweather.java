package com.example.weather_forecast_service.dto.openweather;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonIgnoreProperties
public class WeatherFromOpenweather implements Serializable {

    @JsonProperty("list")
    private List<CityInfo> cityInfo;
}
