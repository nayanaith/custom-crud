package com.naya.customer_crud.controller;

import com.naya.customer_crud.dto.CustomerDto;
import com.naya.customer_crud.exceptions.InvalidCustomerException;
import com.naya.customer_crud.service.CustomerService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(value = "/customers/new", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerDto createNewCustomer(@RequestBody CustomerDto customerDto) {
        CustomerDto createdCustomer = customerService.createNewCustomer(customerDto);
        return createdCustomer;
    }

    @DeleteMapping(value = "/customers/{id}")
    public void deleteById(@PathVariable Long id) {
        customerService.deleteCustomerById(id);
    }

    @DeleteMapping(value = "/customers")
    public void deleteCustomer(@RequestBody CustomerDto customerDto) {
        customerService.deleteCustomer(customerDto);
    }

    @GetMapping(value = "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CustomerDto> getAllCustomers() {
        List<CustomerDto> customers = customerService.getAllCustomers();
        return customers;
    }

    @GetMapping(value = "/customers/{id}")
    public CustomerDto getCustomerByI(@PathVariable Long id) {
        if (id < 0) {
            throw new InvalidCustomerException("Customer id " + id + " is invalid");
        }
        return customerService.getCustomerById(id);
    }

    @PutMapping(value="/customers", consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerDto updateCustomer(CustomerDto customerDto){
        return customerService.updateCustomer(customerDto);
    }
}
