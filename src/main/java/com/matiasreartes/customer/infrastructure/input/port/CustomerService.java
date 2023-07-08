package com.matiasreartes.customer.infrastructure.input.port;

import com.matiasreartes.customer.domain.Customer;

public interface CustomerService {
    Customer createCustomer(String name, String country);
    Customer getById(String id);
}
