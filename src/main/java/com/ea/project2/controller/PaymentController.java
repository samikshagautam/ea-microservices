package com.ea.project2.controller;

import com.ea.project2.entity.Card;
import com.ea.project2.entity.PayPalTransaction;
import com.ea.project2.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/")
    public Card addNewCard(@RequestBody Card card) throws Exception {
        return paymentService.addCard(card);
    }

    @DeleteMapping("/{id}")
    public Card deleteCard(@PathVariable("id") Long cardId) throws Exception {
        return paymentService.deleteCard(cardId);
    }

    @GetMapping("/user/{id}")
    public List<Card> getAllCard(@PathVariable("id") Long userId) {
        return paymentService.getAllCard(userId);
    }

    @GetMapping("/pay/card/{id}")
    public void payViaCard(@PathVariable("id") Long cardId) {

    }

    //create PayPal charge token
    @GetMapping("/pay/paypal/token/{id}/{shippingId}")
    public String createPayPalChargeToken(@PathVariable("id") Long accountId, @PathVariable("shippingId") Long shippingId) {
        String token = paymentService.createPayPalChargeToken(accountId, shippingId);
        return token;

    }

    @GetMapping("/pay/paypal/charge/{token}")
    public PayPalTransaction chargePayPalUser(@PathVariable("token") String token) {
        return paymentService.chargePayPalUser(token);
    }

}
