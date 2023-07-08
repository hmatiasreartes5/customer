package com.matiasreartes.customer.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Customer {

    @Id
    private String id;
    private String name;
    private String country;

    public Customer() {
    }
}
