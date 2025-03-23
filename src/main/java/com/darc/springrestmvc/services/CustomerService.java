package com.darc.springrestmvc.services;

import com.darc.springrestmvc.model.CustomerDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerService {

    List<CustomerDTO> listCustomers();

    Optional<CustomerDTO> getCustomerById(UUID customerId);

    CustomerDTO saveCustomer(CustomerDTO customer);

    Optional<CustomerDTO> updateCustomerById(UUID customerId, CustomerDTO customer);

    Boolean deleteById(UUID customerId);

    Optional<CustomerDTO> updateCustomerByPatch(UUID customerId, CustomerDTO customer);
}
