package com.ecommerce.demo.payment.controller;

import com.ecommerce.demo.payment.service.PaymentService;
import com.ecommerce.demo.payment.model.PaymentProvider;
import com.ecommerce.demo.payment.model.PaymentRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pay")
@Slf4j
public class PaymentController {

  private final PaymentService paymentService;

  public PaymentController(PaymentService paymentService) {
    this.paymentService = paymentService;
  }

  @PostMapping
  public ResponseEntity<Object> pay(
      @Param("provider")
          PaymentProvider provider, @RequestBody PaymentRequest payment) {
    return ResponseEntity.ok(paymentService.pay(provider, payment));
  }
}
