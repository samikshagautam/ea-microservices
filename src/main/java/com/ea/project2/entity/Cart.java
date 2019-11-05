package com.ea.project2.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Transient
    private List<CartItem> cartItems;

    @Column(name = "shipping_cost")
    private Double shippingCost;
}
