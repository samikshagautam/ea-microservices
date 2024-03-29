package com.ea.project2.service;

import com.ea.project2.entity.Card;
import com.ea.project2.entity.PayPalTransaction;
import com.ea.project2.repository.CardRepository;
import com.ea.project2.repository.PayPalTransactionRepository;
import com.ea.project2.trans.Trans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private CartService cartService;

    @Autowired
    private Trans trans;

    @Autowired
    private PayPalTransactionRepository repository;

    public Card addCard(Card card) throws Exception {
        if (card == null) {
            throw new Exception("Data expected with this request");
        }

        Card card1 = cardRepository.findByNumberAndAccountId(card.getNumber(), card.getAccountId());
        if (card1 != null) {
            throw new Exception(trans.late("Card is already registered in this account!"));
        }

        return cardRepository.save(card);
    }

    public Card deleteCard(Long id) throws Exception {
        Card card = cardRepository.findById(id).get();

        if (card == null) {
            throw new Exception(trans.late("Card not found!"));
        }

        cardRepository.delete(card);
        return card;
    }

    public List<Card> getAllCard(Long accountId) {
        return cardRepository.findAllByAccountId(accountId);
    }

    //create paypal payment token
    public String createPayPalChargeToken(Long accountId, Long shippingId) {
        double cartTotal = cartService.getCartTotal(accountId);
        double shipping = 10.0;
        double orderTotal = cartTotal + shipping;
        //return a dummy charging token
        return orderTotal + "-" + accountId + "-" + shippingId;
    }

    //100.00-420-580
    //charge user and save transaction to database
    public PayPalTransaction chargePayPalUser(String token) {

        String[] split = token.split("-");
        Double orderTotal = Double.valueOf(split[0]);//convert string to double
        Long accountId = Long.valueOf(split[1]);
        Long shippingId = Long.valueOf(split[2]);

        PayPalTransaction payPalTransaction = new PayPalTransaction();
        payPalTransaction.setChargeToken(token);
        payPalTransaction.setTransactionToken(token);
        payPalTransaction.setAccountId(accountId);
        payPalTransaction.setAmount(orderTotal);
        payPalTransaction.setEmail("dummy@dummy.com");
        payPalTransaction.setShippingId(shippingId);

        return repository.save(payPalTransaction);


    }


}



