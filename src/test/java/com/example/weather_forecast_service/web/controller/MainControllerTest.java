package com.example.weather_forecast_service.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@Slf4j
class MainControllerTest extends AbstractContextController {

    private static final String BASE_URL = "/";

    private static final String WRONG_PARAM = "wrong";

    private static final String OPENWEATHER_SERVICE = "openweather";

    private static final String WEATHERSTACK_SERVICE = "weatherstack";

    @Test
    public void shouldRedirectToOpenweatherControllerProperly() throws Exception {
        log.info("Test MainController getMainPage() method redirect to OpenweatherController");

        mockMvc.perform(get(BASE_URL)
                                .param("service", OPENWEATHER_SERVICE)
                                .param("city", CITY))
                .andDo(print())
                .andReturn();
    }

    @Test
    public void shouldRedirectToWeatherstackControllerProperly() throws Exception {
        log.info("Test MainController getMainPage() method redirect to WeatherstackController");

        mockMvc.perform(get(BASE_URL)
                                .param("service", WEATHERSTACK_SERVICE)
                                .param("city", CITY))
                .andDo(print())
                .andReturn();
    }

    @Test
    public void shouldReturnStatus302WhenServiceIsWrong() throws Exception {
        log.info("Test MainController getMainPage() with a wrong service param");

        mockMvc.perform(get(BASE_URL)
                                .param("service", WRONG_PARAM)
                                .param("city", CITY))
                .andDo(print())
                .andExpect(status().is(302))
                .andReturn();
    }

    @Test
    public void shouldReturnStatus302WhenCityIsEmpty() throws Exception {
        log.info("Test MainController getMainPage() with an empty city param");

        mockMvc.perform(get(BASE_URL)
                .param("service", OPENWEATHER_SERVICE)
                .param("city", ""))
                .andDo(print())
                .andExpect(status().is(302))
                .andReturn();
    }

        @Test
        public void shouldReturnStatus302WhenCityIsWrong() throws Exception {
            log.info("Test MainController getMainPage() with a wrong city param");

            mockMvc.perform(get(BASE_URL)
                    .param("service", OPENWEATHER_SERVICE)
                    .param("city", WRONG_PARAM))
                    .andDo(print())
                    .andExpect(status().is(302))
                    .andReturn();
        }
}