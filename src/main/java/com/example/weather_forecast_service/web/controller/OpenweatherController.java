package com.example.weather_forecast_service.web.controller;

import com.example.weather_forecast_service.dto.WeatherInformation;
import com.example.weather_forecast_service.service.WeatherService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/openweather")
public class OpenweatherController {

    @Value("${api.openweather.key}")
    private String API_KEY;

    private final WeatherService weatherService;

    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/find?q=%s&appid=%s&units=metric";

    public OpenweatherController(@Qualifier("openweatherService") WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public ResponseEntity getResponse(@CookieValue(value = "city", defaultValue = "Moscow") String city) throws Throwable {

        String requestUri = String.format(BASE_URL, city, API_KEY);
        WeatherInformation currentData = weatherService.getCurrentData(requestUri);

        return ResponseEntity.ok(currentData);
    }

}
