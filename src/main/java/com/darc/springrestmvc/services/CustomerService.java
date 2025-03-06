package com.darc.springrestmvc.services;

import com.darc.springrestmvc.model.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    List<Customer> listCustomers();

    Customer getCustomerById(UUID customerId);

    Customer saveCustomer(Customer customer);
}
