package com.matiasreartes.customer.infrastructure.input.adapter;

import com.matiasreartes.customer.domain.Orders;
import com.matiasreartes.customer.infrastructure.input.port.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public Orders createOrder(
            @RequestParam String customerId,
            @RequestParam BigDecimal totalAmount) {
        return orderService.createOrder(customerId, totalAmount);
    }
}
