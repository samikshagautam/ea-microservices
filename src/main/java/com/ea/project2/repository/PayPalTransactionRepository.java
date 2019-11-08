package com.ea.project2.repository;

import com.ea.project2.entity.PayPalTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayPalTransactionRepository extends JpaRepository<PayPalTransaction, Long> {
}
