package com.ecommerce.demo.transaction.controller;

import com.ecommerce.demo.transaction.model.TransactionItem;
import com.ecommerce.demo.transaction.service.TransactionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

  private final TransactionService transactionService;

  public TransactionController(TransactionService transactionService) {
    this.transactionService = transactionService;
  }

  @GetMapping("/{userId}")
  public List<TransactionItem> getAllTransactions(@PathVariable BigInteger userId) {
    return transactionService.getAllTransactions(userId);
  }

}
