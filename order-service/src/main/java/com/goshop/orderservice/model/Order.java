package com.goshop.orderservice.model;

import javax.persistence.*;

@Entity
public class Order {

    @Id
    @GeneratedValue
    private long id;

}
