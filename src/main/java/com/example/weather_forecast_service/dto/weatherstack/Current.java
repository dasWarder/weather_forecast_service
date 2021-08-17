package com.example.weather_forecast_service.dto.weatherstack;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties
public class Current implements Serializable {

    @JsonProperty("temperature")
    private Integer temperature;

    @JsonProperty("humidity")
    private Long humidity;

}
