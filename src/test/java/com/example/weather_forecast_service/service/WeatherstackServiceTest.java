package com.example.weather_forecast_service.service;

import com.example.weather_forecast_service.dto.WeatherInformation;
import com.example.weather_forecast_service.dto.weatherstack.Current;
import com.example.weather_forecast_service.dto.weatherstack.WeatherFromWeatherstack;
import com.example.weather_forecast_service.exception.CityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


class WeatherstackServiceTest extends AbstractBaseWeatherService {

    private WeatherstackService weatherstackService = new WeatherstackService(template, mapper);

    private static final String BASE_URL =
            "http://api.weatherstack.com/current?access_key=dgdfgdgdfg&query=Moscow";

    private static final WeatherFromWeatherstack TEST_WEATHER = new WeatherFromWeatherstack(
                                                                                    new Current(23, 65L));

    private static final WeatherInformation TEST_RESPONSE = new WeatherInformation(TEST_WEATHER
                                                                                            .getCurrent()
                                                                                            .getTemperature(),
                                                                                    TEST_WEATHER
                                                                                            .getCurrent()
                                                                                            .getHumidity());
    @Test
    @Override
    protected void shouldReceiveCurrentWeatherProperly() throws CityNotFoundException {
        super.shouldReceiveCurrentWeatherProperly();

        Mockito.when(template.getForObject(BASE_URL, WeatherFromWeatherstack.class)).thenReturn(TEST_WEATHER);
        Mockito.when(mapper.fromWeatherstackToWeatherInfo(TEST_WEATHER)).thenReturn(TEST_RESPONSE);

        WeatherInformation currentData = weatherstackService.getCurrentData(BASE_URL);

        Assertions.assertNotNull(currentData);
        Assertions.assertEquals(TEST_RESPONSE, currentData);
    }

    @Test
    @Override
    protected void shouldThrowExceptionWhenURIisNull() {
        super.shouldThrowExceptionWhenURIisNull();

        Assertions.assertThrows(IllegalArgumentException.class,
                                                        () -> weatherstackService.getCurrentData(null));
    }
}