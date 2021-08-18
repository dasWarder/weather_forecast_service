package com.example.weather_forecast_service.service;

import com.example.weather_forecast_service.dto.WeatherInformation;
import com.example.weather_forecast_service.dto.openweather.CityInfo;
import com.example.weather_forecast_service.dto.openweather.Main;
import com.example.weather_forecast_service.dto.openweather.WeatherFromOpenweather;
import com.example.weather_forecast_service.exception.CityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;


class OpenweatherServiceTest extends AbstractBaseWeatherService {

    private OpenweatherService openweatherService = new OpenweatherService(template, mapper);

    private static final String BASE_URL =
            "http://api.openweathermap.org/data/2.5/find?q=Moscow&appid=fdfgdydrbgdfhdfhdfh&units=metric";

    private static final WeatherFromOpenweather TEST_RESPONSE = new WeatherFromOpenweather(List.of(
                                                                                                new CityInfo( Main.builder()
                                                                                                                .temp(23.0)
                                                                                                                .humidity(56L)
                                                                                                                .build())));
    private static final WeatherInformation MAPPED_RESPONSE = new WeatherInformation((int) Math.round(TEST_RESPONSE
                                                                                                                .getCityInfo()
                                                                                                                .get(0)
                                                                                                                .getMain()
                                                                                                                .getTemp()),
                                                                                                        TEST_RESPONSE
                                                                                                                    .getCityInfo()
                                                                                                                    .get(0)
                                                                                                                    .getMain()
                                                                                                                    .getHumidity());
    @Test
    @Override
    public void shouldReceiveCurrentWeatherProperly() throws CityNotFoundException {
        super.shouldReceiveCurrentWeatherProperly();

        Mockito.when(template.getForObject(BASE_URL, WeatherFromOpenweather.class)).thenReturn(TEST_RESPONSE);
        Mockito.when(mapper.fromOpenweatherToWeatherInfo(TEST_RESPONSE
                                                                .getCityInfo()
                                                                        .get(0))).thenReturn(MAPPED_RESPONSE);

        WeatherInformation mappedResponse = openweatherService.getCurrentData(BASE_URL);

        Assertions.assertEquals(MAPPED_RESPONSE, mappedResponse);
    }

    @Test
    @Override
    public void shouldThrowExceptionWhenURIisNull()  {
        super.shouldThrowExceptionWhenURIisNull();

        Assertions.assertThrows(IllegalArgumentException.class,
                                        () -> openweatherService.getCurrentData(null));
    }

}