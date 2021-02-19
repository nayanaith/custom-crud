package com.naya.customer_crud.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class CustomerDto {
    private Long id;

    @Length(max = 40, min = 2, message = "Can't be more than 40 characters or less than 2 characters")
    private String firstName;

    @Length(max = 40, min = 2, message = "Can't be more than 40 characters or less than 2 characters")
    private String lastName;

    @NotBlank(message = "email is required")
    private String emailAddress;
}
