package com.naya.customer_crud.controller;

import com.naya.customer_crud.dto.WeatheResponseDto;
import com.naya.customer_crud.dto.WeatherDto;
import com.naya.customer_crud.service.WeatherService;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//@Api(value="The controller for Weather information")
@Api(tags="Weather", value = "The controller for Weather information")
@RestController
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping(value = "/weather/{zipcode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public WeatheResponseDto getWeatherForZipCode(@PathVariable Integer zipcode) {
        return weatherService.getWeatherInZipCode(zipcode);
    }
}
