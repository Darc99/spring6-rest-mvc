package com.darc.springrestmvc.services;

import com.darc.springrestmvc.model.Customer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerService {

    List<Customer> listCustomers();

    Optional<Customer> getCustomerById(UUID customerId);

    Customer saveCustomer(Customer customer);

    void updateCustomerById(UUID customerId, Customer customer);

    void deleteById(UUID customerId);

    void updateCustomerByPatch(UUID customerId, Customer customer);
}
