package com.naya.customer_crud.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ThirdPartyWebServicesConfiguration {

    @Bean
    public WebClient weatheApiClient() throws Exception{
        return WebClient.create("http://api.openweathermap.org/data/2.5/weather");

    }
}
