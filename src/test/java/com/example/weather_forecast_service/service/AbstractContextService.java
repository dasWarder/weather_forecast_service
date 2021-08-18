package com.example.weather_forecast_service.service;

import com.example.weather_forecast_service.AbstractContext;
import com.example.weather_forecast_service.exception.CityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public abstract class AbstractContextService extends AbstractContext {

    protected static final String CITY = "Moscow";

    @Test
    protected void shouldReceiveDataProperly() throws CityNotFoundException {
        log.info("Test getCurrentData() method for Moscow city");
    }

    @Test
    protected void shouldThrowExceptionWhenURIisNull() {
        log.info("Test getCurrentData() method should throw an exception when the uri is null");
    }
}
