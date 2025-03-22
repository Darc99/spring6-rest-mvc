package com.darc.springrestmvc.services;

import com.darc.springrestmvc.mappers.CustomerMapper;
import com.darc.springrestmvc.model.CustomerDTO;
import com.darc.springrestmvc.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Primary
@RequiredArgsConstructor
public class CustomerServiceJPA implements CustomerService {
    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    @Override
    public List<CustomerDTO> listCustomers() {

        return customerRepository.findAll()
                .stream()
                .map(customerMapper::customerToCustomerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CustomerDTO> getCustomerById(UUID customerId) {

        return Optional.ofNullable(customerMapper.customerToCustomerDTO(customerRepository.findById(customerId)
                .orElse(null)));
    }

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customer) {
        return null;
    }

    @Override
    public void updateCustomerById(UUID customerId, CustomerDTO customer) {

    }

    @Override
    public void deleteById(UUID customerId) {

    }

    @Override
    public void updateCustomerByPatch(UUID customerId, CustomerDTO customer) {

    }
}
