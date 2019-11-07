package com.ea.project2.controller;

import com.ea.project2.entity.Cart;
import com.ea.project2.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/")
    public Cart addCart(@RequestBody Cart cart) throws Exception {
        return cartService.addToCart(cart);
    }

    @DeleteMapping("/{id}")
    public Cart deleteCart(@PathVariable("id") Long id, @RequestBody Cart cart) throws Exception {
        return cartService.removeCartItem(id);

    }

    @PatchMapping("/{id}")
    public Cart updateCart(@PathVariable("id") Long id, @RequestBody Cart cart) throws Exception {
        return cartService.updateQty(cart.getQuantity(), id);
    }

    @GetMapping("/{id}")
    public List<Cart> getByUserId(@PathVariable("id") Long userId) {
        return cartService.getCart(userId);
    }
}
