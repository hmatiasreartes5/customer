package com.matiasreartes.customer.infrastructure.output.port;

import com.matiasreartes.customer.domain.Orders;

public interface OrderRepository {
    void saveOrder(Orders orders);
    Orders getById(String id);
}
