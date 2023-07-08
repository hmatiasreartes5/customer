package com.matiasreartes.customer.application;

import com.matiasreartes.customer.domain.Orders;
import com.matiasreartes.customer.infrastructure.input.port.OrderService;
import com.matiasreartes.customer.infrastructure.output.port.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class OrderUseCase implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Orders createOrder(String customerId, BigDecimal totalAmount) {
        Orders orders = Orders.builder()
                .id(UUID.randomUUID().toString())
                .customerId(customerId)
                .totalAmount(totalAmount)
                .build();
        orderRepository.saveOrder(orders);
        return orders;
    }

    @Override
    public Orders getById(String id) {
        return orderRepository.getById(id);
    }
}
