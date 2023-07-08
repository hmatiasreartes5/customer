package com.matiasreartes.customer.infrastructure.output.adapter.inMemory;

import com.matiasreartes.customer.domain.Orders;
import com.matiasreartes.customer.infrastructure.output.port.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryOrderRepository implements OrderRepository {
    List<Orders> orders = new ArrayList<>();

    @Override
    public void saveOrder(Orders orders) {
        this.orders.add(orders);
    }

    @Override
    public Orders getById(String id) {
        return orders.stream()
                .filter(order -> order.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }
}
