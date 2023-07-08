package com.matiasreartes.customer.infrastructure.output.adapter.inMemory;

import com.matiasreartes.customer.domain.Customer;
import com.matiasreartes.customer.infrastructure.output.port.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {
    private List<Customer> customers = new ArrayList<>();

    @Override
    public void save(Customer customer) {
        customers.add(customer);
    }

    @Override
    public Customer getById(String id) {
        return customers.stream()
                .filter(customer -> customer.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }
}
