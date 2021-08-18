package com.example.weather_forecast_service.service;

import com.example.weather_forecast_service.dto.WeatherInformation;
import com.example.weather_forecast_service.exception.CityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;


class WeatherstackServiceIntegrationTest extends AbstractContextService {

    @Value("${test-api.weatherstack.key}")
    private String API_KEY;

    @Autowired
    private WeatherstackService weatherstackService;

    private static final String BASE_URL = "http://api.weatherstack.com/current?access_key=%s&query=%s";

    @Test
    @Override
    protected void shouldReceiveDataProperly() throws CityNotFoundException {
        super.shouldReceiveDataProperly();
        String requestUri = String.format(BASE_URL, API_KEY, CITY);

        WeatherInformation currentData = weatherstackService.getCurrentData(requestUri);

        Assertions.assertNotNull(currentData);
    }

    @Test
    @Override
    protected void shouldThrowExceptionWhenURIisNull() {
        super.shouldThrowExceptionWhenURIisNull();

        Assertions.assertThrows(IllegalArgumentException.class,
                                        () -> weatherstackService.getCurrentData(null));
    }
}