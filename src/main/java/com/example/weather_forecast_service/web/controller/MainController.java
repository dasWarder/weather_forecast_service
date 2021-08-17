package com.example.weather_forecast_service.web.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;

@Controller
public class MainController {

    private final static String REDIRECT_URL= "/%s";

    @GetMapping("/")
    public void getMainPage(@RequestParam("service") String serviceName,
                                      @RequestParam("city") String city, HttpServletResponse response) throws IOException {

        Cookie cookie = new Cookie("city", city);
        response.addCookie(cookie);

       response.sendRedirect(String.format(REDIRECT_URL, serviceName.toLowerCase()));
    }
}
