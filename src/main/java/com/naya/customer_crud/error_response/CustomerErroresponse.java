package com.naya.customer_crud.error_response;

import lombok.Data;

@Data
public class CustomerErroresponse {
    private String message;
    private long timeStamp;
    private int statusCode;
}
