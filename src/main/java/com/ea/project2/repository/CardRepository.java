package com.ea.project2.repository;

import com.ea.project2.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card,Long> {
    Card findByNumberAndAccountId(String number, Long accountId);

    List<Card> findAllByAccountId(Long accountId);
}
