package com.ecommerce.demo.order.service;

import com.ecommerce.demo.order.model.TransactionItem;
import com.ecommerce.demo.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

  private final OrderRepository orderRepository;

  public OrderService(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  public List<TransactionItem> getAllTransactions(BigInteger userId) {
    return orderRepository.findAllByUserId(userId)
        .stream()
        .map(t -> TransactionItem.builder().amount(t.getAmount())
            .purchaseTime(t.getPurchaseTime())
            .status(t.getStatus())
            .userId(t.getUserId())
            .transactionId(t.getTransactionId())
            .statusReadable(t.getStatus().getStatusReadable()).build())
        .collect(Collectors.toList());
  }
}
