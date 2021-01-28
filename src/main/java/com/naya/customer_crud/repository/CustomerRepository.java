package com.naya.customer_crud.repository;

import com.naya.customer_crud.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
}
