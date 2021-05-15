package com.ecommerce.demo.payment.service;

import com.ecommerce.demo.payment.model.PaymentProvider;
import com.ecommerce.demo.payment.model.PaymentRequest;
import com.ecommerce.demo.payment.model.PaymentResponse;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

  private final PaymentConnector paymentConnector;

  public PaymentService(PaymentConnector paymentConnector) {
    this.paymentConnector = paymentConnector;
  }

  public PaymentResponse pay(PaymentProvider provider, PaymentRequest request) {
    return paymentConnector.pay(provider, request);
  }
}
