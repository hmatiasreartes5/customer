package com.matiasreartes.customer.infrastructure.output.port;

import com.matiasreartes.customer.domain.Customer;

public interface CustomerRepository {
    void save(Customer customer);
    Customer getById(String id);
}
