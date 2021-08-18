package com.example.weather_forecast_service.service;

import com.example.weather_forecast_service.exception.CityNotFoundException;
import com.example.weather_forecast_service.mapping.WeatherInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestTemplate;

@Slf4j
public abstract class AbstractBaseWeatherService {

    protected final RestTemplate template = Mockito.mock(RestTemplate.class);

    protected final WeatherInfoMapper mapper = Mockito.mock(WeatherInfoMapper.class);

    @Test
    protected void shouldReceiveCurrentWeatherProperly() throws CityNotFoundException {
        log.info("Test getCurrentData() method");
    }

    @Test
    protected void shouldThrowExceptionWhenURIisNull() {
        log.info("Test getCurrentData() method throw exception when a param is nullable");
    }
}
