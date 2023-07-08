package com.matiasreartes.customer.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Builder
@Setter
@Getter
@Entity
public class Orders {

    @Id
    private String id;
    private String customerId;
    private BigDecimal totalAmount;
}
