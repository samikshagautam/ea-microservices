package com.ea.project2.service;

import com.ea.project2.entity.Cart;
import com.ea.project2.entity.Product;
import com.ea.project2.repository.CartRepository;
import com.ea.project2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    public Cart addToCart(Cart cart) throws Exception {

        Product product = productRepository.findById(cart.getProductId()).get();

        if (product == null) {
            throw new Exception("Product does not exist!");
        }

        cart.setRate(product.getPrice());
        cart.setPrice(product.getPrice() * cart.getQuantity());

        return cartRepository.save(cart);

    }

    public Cart removeCartItem(Long cartId) throws Exception {
        Cart cart = cartRepository.findById(cartId).get();
        if (cart == null) {
            throw new Exception("Cart item not found");
        }
        cartRepository.delete(cart);
        return cart;
    }

    //update cart item
    public Cart updateQty(int qty, Long cartId) throws Exception {
        Cart cart = cartRepository.findById(cartId).get();
        if (cart == null) {
            throw new Exception("Cart item not found!");
        }

        cart.setQuantity(qty);
        cart.setPrice(cart.getRate() * cart.getQuantity());
        return cartRepository.save(cart);
    }

    public List<Cart> getCart(Long userId){
        return cartRepository.findByAccountId(userId);
    }
}
