package com.ecommerce.demo.transaction.service;

import com.ecommerce.demo.transaction.model.TransactionItem;
import com.ecommerce.demo.transaction.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {

  private final TransactionRepository transactionRepository;

  public TransactionService(TransactionRepository transactionRepository) {
    this.transactionRepository = transactionRepository;
  }

  public List<TransactionItem> getAllTransactions(BigInteger userId) {
    return transactionRepository.findAllByUserId(userId)
        .stream()
        .map(t -> TransactionItem.builder().amount(t.getAmount())
            .purchaseTime(t.getPurchaseTime())
            .status(t.getStatus())
            .userId(t.getUserId()).build())
        .collect(Collectors.toList());
  }
}
