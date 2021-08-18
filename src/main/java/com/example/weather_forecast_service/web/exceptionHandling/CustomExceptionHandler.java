package com.example.weather_forecast_service.web.exceptionHandling;


import com.example.weather_forecast_service.exception.CityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = {
            CityNotFoundException.class
    })
    public ExceptionResponse serviceExceptions(Exception e) {

      log.info("Serving an exception from service");

      String[] slicedMessage = e.getCause().toString().split("\\.");
      String reason = slicedMessage[slicedMessage.length - 1];

      ExceptionResponse response = ExceptionResponse.builder()
                                                    .className(e.getClass().getSimpleName())
                                                    .message(reason)
                                                    .build();
      return response;
    }
}
