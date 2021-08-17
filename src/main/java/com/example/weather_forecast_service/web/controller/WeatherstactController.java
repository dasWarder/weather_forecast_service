package com.example.weather_forecast_service.web.controller;

import com.example.weather_forecast_service.dto.WeatherInformation;
import com.example.weather_forecast_service.exception.CityNotFoundException;
import com.example.weather_forecast_service.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/weatherstack")
public class WeatherstactController {

    @Value("${api.weatherstack.key}")
    private String API_KEY;

    private final WeatherService weatherService;

    private static final String BASE_URI = "http://api.weatherstack.com/current?access_key=%s&query=%s";

    public WeatherstactController(@Qualifier("weatherstackService") WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public ResponseEntity getCurrentWeather(@RequestParam("city") String city) throws Throwable {

        String requestUri = String.format(BASE_URI, API_KEY, city);
        WeatherInformation currentWeather = weatherService.getCurrentData(requestUri);

        return ResponseEntity.ok(currentWeather);
    }
}