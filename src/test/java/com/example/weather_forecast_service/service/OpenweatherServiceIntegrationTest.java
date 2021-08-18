package com.example.weather_forecast_service.service;

import com.example.weather_forecast_service.dto.WeatherInformation;
import com.example.weather_forecast_service.exception.CityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.HttpClientErrorException;

@Slf4j
class OpenweatherServiceIntegrationTest extends AbstractContextService {

    @Value("${test-api.openweather.key}")
    private String API_KEY;

    @Autowired
    private OpenweatherService openweatherService;

    private final String BASE_URL = "http://api.openweathermap.org/data/2.5/find?q=%s&appid=%s&units=metric";


    @Test
    @Override
    public void shouldReceiveDataProperly() throws CityNotFoundException {
        super.shouldReceiveDataProperly();
        String requestUri = String.format(BASE_URL, CITY, API_KEY);

        WeatherInformation currentData = openweatherService.getCurrentData(requestUri);
        Assertions.assertNotNull(currentData);
    }

    @Test
    @Override
    public void shouldThrowExceptionWhenURIisNull() {
        super.shouldThrowExceptionWhenURIisNull();
        Assertions.assertThrows(IllegalArgumentException.class,
                                                        () -> openweatherService.getCurrentData(null));
    }

    @Test
    public void shouldThrowExceptionWhenApiKeyIsAbsence() {
        log.info("Test getCurrentData() method should throw exception when the api key is absence");
        String requestUri = String.format(BASE_URL, CITY, null);

        Assertions.assertThrows(HttpClientErrorException.Unauthorized.class,
                                            () -> openweatherService.getCurrentData(requestUri));
    }

}