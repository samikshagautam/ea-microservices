package com.ea.project2.service;

import com.ea.project2.entity.Order;
import com.ea.project2.repository.OrderItemRepository;
import com.ea.project2.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

   // public Order addOrder(Long accountId, String paymentType, Long shippingId)
}
