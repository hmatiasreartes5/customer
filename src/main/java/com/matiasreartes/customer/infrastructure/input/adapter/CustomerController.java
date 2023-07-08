package com.matiasreartes.customer.infrastructure.input.adapter;

import com.matiasreartes.customer.domain.Customer;
import com.matiasreartes.customer.infrastructure.input.port.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/create")
    public Customer create(
        @RequestParam String name,
        @RequestParam String country) {
        return customerService.createCustomer(name, country);
    }

    @GetMapping("/{id}")
    public Customer getCustomer(
            @PathVariable(value = "id") String customerId) {
        return customerService.getById(customerId);
    }
}
