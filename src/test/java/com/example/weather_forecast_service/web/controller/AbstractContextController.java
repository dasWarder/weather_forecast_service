package com.example.weather_forecast_service.web.controller;

import com.example.weather_forecast_service.AbstractContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
public abstract class AbstractContextController extends AbstractContext {

    @Autowired
    protected MockMvc mockMvc;


    protected static final String CITY = "Moscow";
}
