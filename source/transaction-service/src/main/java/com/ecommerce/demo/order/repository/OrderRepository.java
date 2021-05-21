package com.ecommerce.demo.order.repository;

import com.ecommerce.demo.order.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, BigInteger> {

  List<OrderEntity> findAllByUserId(BigInteger userId);
  OrderEntity findFirstByTransactionId(String transactionId);
}
