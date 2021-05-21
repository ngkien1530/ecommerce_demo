package com.ecommerce.demo.order.controller;

import com.ecommerce.demo.order.model.TransactionItem;
import com.ecommerce.demo.order.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

  private final OrderService orderService;

  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @GetMapping("/{userId}")
  public List<TransactionItem> getAllTransactions(@PathVariable BigInteger userId) {
    return orderService.getAllTransactions(userId);
  }

}
