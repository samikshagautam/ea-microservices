package com.ea.project2.repository;

import com.ea.project2.entity.Cart;
import com.ea.project2.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}
