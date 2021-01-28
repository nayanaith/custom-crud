package com.naya.customer_crud.mapper;

import com.naya.customer_crud.dto.CustomerDto;
import com.naya.customer_crud.entity.Customer;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class DomainMapper extends ConfigurableMapper {

    @Override
    protected void configure(MapperFactory mapperFactory){
        mapperFactory.classMap(Customer.class, CustomerDto.class)
                .field("firstName", "firstName")
                .field("lastName","lastName")
                .field("email","emailAddress");
    }
}
