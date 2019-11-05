package com.ea.project2.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Transient
    private List<OrderItem> orderItems;

    @Column(name = "address_id")
    private Long addressId;

    @Column(name = "sub_total")
    private Double subTotal;

    @Column(name = "shipping_cost")
    private Double shippingCost;

    @Column(name = "tax")
    private Double tax;

    @Column(name = "order_total")
    private Double orderTotal;






}
