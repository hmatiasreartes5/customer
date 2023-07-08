package com.matiasreartes.customer.application;

import com.matiasreartes.customer.domain.Customer;
import com.matiasreartes.customer.infrastructure.input.port.CustomerService;
import com.matiasreartes.customer.infrastructure.output.port.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerUseCase implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(String name, String country) {
        Customer customer = new Customer();
        customer.setId(UUID.randomUUID().toString());
        customer.setName(name);
        customer.setCountry(country);

        customerRepository.save(customer);
        return customer;
    }

    @Override
    public Customer getById(String id) {
        return customerRepository.getById(id);
    }
}
