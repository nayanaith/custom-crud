package com.naya.customer_crud.dto;

import lombok.Data;

@Data
public class WeatherDto {
    private CoordinatesDto coordinates;
    private SkyLookDto skyLookDto;
}
