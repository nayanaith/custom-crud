package com.naya.customer_crud.service;

import com.naya.customer_crud.dto.CustomerDto;
import com.naya.customer_crud.entity.Customer;
import com.naya.customer_crud.mapper.DomainMapper;
import com.naya.customer_crud.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    private final DomainMapper domainMapper;

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<CustomerDto> customers = domainMapper.mapAsList(customerRepository.findAll(),CustomerDto.class);
        return customers;
    }

    @Override
    public CustomerDto createNewCustomer(CustomerDto customerDto) {
        Customer customer = domainMapper.map(customerDto, Customer.class);
        return domainMapper.map(customerRepository.save(customer), CustomerDto.class);
    }

    @Override
    public void deleteCustomer(CustomerDto customerDto) {
        Customer customer = domainMapper.map(customerDto, Customer.class);
        customerRepository.delete(customer);
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public CustomerDto getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id).get();
        return domainMapper.map(customerRepository.findById(id).get(),CustomerDto.class);
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customerToUpdate) {
        Customer customerWithUpdatedValues = domainMapper.map(customerToUpdate, Customer.class);
        CustomerDto customerAfterSave = domainMapper.map(customerRepository.save(customerWithUpdatedValues), CustomerDto.class);
        return customerAfterSave;
    }
}
