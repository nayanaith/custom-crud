package com.naya.customer_crud.error_response;

import com.naya.customer_crud.exceptions.InvalidCustomerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

//@ControllerAdvice
public class ControllerAdvisor {//extends ResponseEntityExceptionHandler {
  //  @ExceptionHandler(InvalidCustomerException.class)
    public ResponseEntity<Object> handleCityNotFoundException(InvalidCustomerException ex,
                                                              WebRequest request){
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timeStamp", LocalDateTime.now());
        body.put("message","Customer Not Found with id "+request.getContextPath());
        body.put("exception",ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
