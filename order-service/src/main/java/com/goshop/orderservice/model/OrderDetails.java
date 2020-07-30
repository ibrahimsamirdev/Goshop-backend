package com.goshop.orderservice.model;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
public class OrderDetails {

    @Id
    @GeneratedValue
    private long Id;

}
