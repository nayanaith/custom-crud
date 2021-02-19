package com.naya.customer_crud.service;

import com.naya.customer_crud.dto.WeatheResponseDto;
import com.naya.customer_crud.dto.WeatherDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;

@Service
@Slf4j
public class WeatherServiceImpl implements WeatherService {
    private final WebClient webClient;
    private final String API_KEY = "293d900481b58175cf850f72e3d598c2";
    private static final Duration REQUEST_TIMEOUT = Duration.ofSeconds(30);

    public WeatherServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    public WeatheResponseDto getWeatherInZipCode(Integer zipCode) {
//        WeatherDto weatherDto =  webClient.get().uri("?zip=" + zipCode + ",us&appid=" + API_KEY)
//                .retrieve()
//                .bodyToMono(WeatherDto.class)
//                .block(REQUEST_TIMEOUT);


        WeatheResponseDto weatherResponse =  webClient.get().uri("?zip=" + zipCode + ",us&appid=" + API_KEY)
                .retrieve()
                .bodyToMono(WeatheResponseDto.class)
                .block(REQUEST_TIMEOUT);

        return weatherResponse;
    }
}
