package com.ea.project2.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "shipping_address")
public class ShippingAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "address1")
    private String address1;

    @Column(name = "address2")
    private String address2;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zip_code")
    private int zipCode;

    @Column(name = "phone_num")
    private String phoneNum;
}
