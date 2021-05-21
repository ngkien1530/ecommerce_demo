package com.ecommerce.demo.payment.repository;

import com.ecommerce.demo.payment.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, BigInteger> {
  TransactionEntity findFirstByTransactionId(String transactionId);
}
