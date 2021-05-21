package com.ecommerce.demo.payment.controller;

import com.ecommerce.demo.payment.model.PaymentStatus;
import com.ecommerce.demo.payment.service.PaymentService;
import com.ecommerce.demo.payment.model.PaymentProvider;
import com.ecommerce.demo.payment.model.PaymentRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api/pay")
@Slf4j
public class PaymentController {

  private final PaymentService paymentService;

  public PaymentController(PaymentService paymentService) {
    this.paymentService = paymentService;
  }

  @PostMapping
  public ResponseEntity<Boolean> createPayment(
      @RequestParam("provider")
          PaymentProvider provider, @RequestBody PaymentRequest payment) {
    paymentService.createPayment(payment);
    return ResponseEntity.ok(Boolean.TRUE);
  }

  @PutMapping
  public ResponseEntity<Boolean> updatePayment(@RequestParam("transactionId") String transactionId,
                                               @RequestBody PaymentStatus status) {
    var res = paymentService.updatePayment(transactionId, status);
    return ResponseEntity.ok(res);
  }
}
