package com.matiasreartes.customer.infrastructure.input.port;

import com.matiasreartes.customer.domain.Orders;

import java.math.BigDecimal;

public interface OrderService {
    Orders createOrder(String customerId, BigDecimal totalAmount);
    Orders getById(String id);
}
