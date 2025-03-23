package com.darc.springrestmvc.mappers;

import com.darc.springrestmvc.entities.Customer;
import com.darc.springrestmvc.model.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    Customer customerDtoToCustomer(CustomerDTO dto);

    CustomerDTO customerToCustomerDTO(Customer customer);
}
