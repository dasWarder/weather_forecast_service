package com.example.weather_forecast_service.service;


import com.example.weather_forecast_service.dto.WeatherInformation;
import com.example.weather_forecast_service.dto.weatherstack.WeatherFromWeatherstack;
import com.example.weather_forecast_service.exception.CityNotFoundException;
import com.example.weather_forecast_service.mapping.WeatherInfoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static org.springframework.util.Assert.notNull;

@Slf4j
@Service
@RequiredArgsConstructor
public class WeatherstackService implements WeatherService {

    private final RestTemplate restTemplate;

    private final WeatherInfoMapper mapper;

    @Override
    public WeatherInformation getCurrentData(String requestUri) {

        notNull(requestUri, "The URI must be not null");
        log.info("Receive current weather for WeatherStack API service");

        WeatherFromWeatherstack dto = restTemplate.getForObject(requestUri, WeatherFromWeatherstack.class);
        WeatherInformation currentWeather = mapper.fromWeatherstackToWeatherInfo(dto);

        return currentWeather;
    }
}
