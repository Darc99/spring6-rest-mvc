package com.darc.springrestmvc.controller;

import com.darc.springrestmvc.entities.Customer;
import com.darc.springrestmvc.model.CustomerDTO;
import com.darc.springrestmvc.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerControllerIT {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerController customerController;

    @Test
    void getCustomers() {

        List<CustomerDTO> dtos = customerController.getCustomers();

        assertThat(dtos.size()).isEqualTo(3);
    }

    @Rollback
    @Transactional
    @Test
    void testEmptyList() {

        customerRepository.deleteAll();
        List<CustomerDTO> dtos = customerController.getCustomers();

        assertThat(dtos.size()).isEqualTo(0);
    }

    @Test
    void getCustomerById() {

        Customer customer = customerRepository.findAll().getFirst();
        CustomerDTO dto = customerController.getCustomerById(customer.getCustomerId());

        assertThat(dto).isNotNull();
    }

    @Test
    void testCustomerIdNotFound() {

        assertThrows(NotFoundException.class, () -> {
            customerController.getCustomerById(UUID.randomUUID());
        });
    }

    @Test
    void newCustomer() {
    }

    @Test
    void updateCustomer() {
    }

    @Test
    void deleteCustomer() {
    }

    @Test
    void updateCustomerByPatch() {
    }
}