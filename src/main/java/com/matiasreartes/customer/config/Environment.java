package com.matiasreartes.customer.config;

import com.matiasreartes.customer.infrastructure.output.port.CustomerRepository;

public interface Environment {
    CustomerRepository customerRepository();
}
