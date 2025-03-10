package com.darc.springrestmvc.controller;

import com.darc.springrestmvc.model.Customer;
import com.darc.springrestmvc.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> getCustomers() {
        return customerService.listCustomers();
    }

    @RequestMapping(value = "{customerId}",method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable("customerId") UUID customerId) {
        return customerService.getCustomerById(customerId);
    }

    @PostMapping
    public ResponseEntity newCustomer(@RequestBody Customer customer) {

        Customer saveCustomer = customerService.saveCustomer(customer);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customer/" + saveCustomer.getCustomerId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }
}
