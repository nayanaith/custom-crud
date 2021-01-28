package com.naya.customer_crud.service;

import com.naya.customer_crud.dto.WeatherDto;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;

public class WeatherServiceImpl implements WeatherService{
    private final WebClient webClient;
    private final String API_KEY = "";
    private static final Duration REQUEST_TIMEOUT = Duration.ofSeconds(30);

    public WeatherServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    public WeatherDto getWeatherInZipCode(Integer zipCode){
        return webClient.get().uri("?zip="+zipCode+",us&appid="+API_KEY)
                .retrieve()
                .bodyToMono(WeatherDto.class)
                .block(REQUEST_TIMEOUT);
    }
}
