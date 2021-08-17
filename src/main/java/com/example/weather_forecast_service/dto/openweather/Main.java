package com.example.weather_forecast_service.dto.openweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties
public class Main implements Serializable {

    @JsonProperty("temp")
    private Double temp;

    @JsonProperty("humidity")
    private Long humidity;
}
