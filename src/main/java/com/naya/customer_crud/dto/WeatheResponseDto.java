package com.naya.customer_crud.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatheResponseDto {

    private String base;
    private int cod;
    private String name;
    private int timeZone;
    private CoordinatesDto coord;
}
