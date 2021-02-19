package com.naya.customer_crud.service;

import com.naya.customer_crud.dto.WeatheResponseDto;
import com.naya.customer_crud.dto.WeatherDto;

public interface WeatherService {
    //WeatherDto getWeatherInZipCode(Integer zipCode);
    WeatheResponseDto getWeatherInZipCode(Integer zipCode);
}
