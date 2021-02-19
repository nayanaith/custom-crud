package com.naya.customer_crud.service;

import com.naya.customer_crud.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    List<CustomerDto> getAllCustomers();

    CustomerDto createNewCustomer(CustomerDto customerDto);

    void deleteCustomer(CustomerDto customerDto);

    void deleteCustomerById(Long id);

    CustomerDto getCustomerById(Long id);

    CustomerDto updateCustomer(CustomerDto customerDto);


}
