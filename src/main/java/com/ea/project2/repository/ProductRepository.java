package com.ea.project2.repository;

import com.ea.project2.entity.Cart;
import com.ea.project2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByNameAndCategoryId(String name, Long catId);


    List<Product> findAllByCategoryId(Long catId);
}
