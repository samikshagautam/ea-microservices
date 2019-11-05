package com.ea.project2.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "cart_item")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "rate")
    private Double rate;

    @Column(name = "price")
    private Double price;

    @Column(name = "cart_id")
    private Long cartId;
}
