package com.ecommerce.demo.transaction.repository;

import com.ecommerce.demo.transaction.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, BigInteger> {

  List<TransactionEntity> findAllByUserId(BigInteger userId);
}
