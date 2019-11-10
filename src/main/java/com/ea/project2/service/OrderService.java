package com.ea.project2.service;

import com.ea.project2.entity.*;
import com.ea.project2.repository.CartRepository;
import com.ea.project2.repository.OrderItemRepository;
import com.ea.project2.repository.OrderRepository;
import com.ea.project2.repository.PayPalTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private PayPalTransactionRepository repository;

    @Autowired
    private CartService cartService;

   //place an Order using the transaction id
    public Order placeAnOrder(Long tranId) throws Exception {

        PayPalTransaction payPalTransaction = repository.findById(tranId).get();

        if (payPalTransaction == null){
            throw  new Exception("Transaction not found!");
        }
        List<Cart> cart = cartService.getCart(payPalTransaction.getAccountId());
        Order order = new Order();
        order.setStatus(OrderStatus.Received);

        order.setAccountId(payPalTransaction.getAccountId());
        order.setAddressId(payPalTransaction.getShippingId());
        order.setShippingCost(10.0);
        order.setPaymentType("paypal");
        order.setSubTotal(cartService.getCartTotal(payPalTransaction.getAccountId()));
        order.setOrderTotal(order.getSubTotal()+order.getShippingCost());

        Order order1 = orderRepository.save(order);

        for(Cart cart1 : cart){
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(cart1.getProductId());
            orderItem.setOrderId(order1.getId());
            orderItem.setPrice(cart1.getPrice());
            orderItem.setQuantity(cart1.getQuantity());
            orderItem.setRate(cart1.getRate());
            orderItemRepository.save(orderItem);
            cartService.removeCartItem(cart1.getId());
        }

        return order1;
    }



}
