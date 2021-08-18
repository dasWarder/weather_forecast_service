package com.example.weather_forecast_service.service;

import com.example.weather_forecast_service.dto.WeatherInformation;
import com.example.weather_forecast_service.dto.openweather.WeatherFromOpenweather;
import com.example.weather_forecast_service.exception.CityNotFoundException;
import com.example.weather_forecast_service.mapping.WeatherInfoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static org.springframework.util.Assert.notNull;

@Slf4j
@Service
@RequiredArgsConstructor
public class OpenweatherService implements WeatherService {

    private final RestTemplate restTemplate;

    private final WeatherInfoMapper mapper;

    @Override
    public WeatherInformation getCurrentData(String requestUri) throws CityNotFoundException {

        notNull(requestUri, "The uri must be not null");
        log.info("Receive a current weather for OpenWeather API service");

        WeatherFromOpenweather response = restTemplate.getForObject(requestUri, WeatherFromOpenweather.class);

        WeatherInformation weatherInformation = response.getCityInfo()
                                                        .stream().map(c -> mapper.fromOpenweatherToWeatherInfo(c))
                                                        .findFirst()
                                                        .orElseThrow(CityNotFoundException::new);

        return weatherInformation;
    }
}
