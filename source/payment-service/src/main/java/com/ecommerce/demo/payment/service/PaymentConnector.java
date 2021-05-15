package com.ecommerce.demo.payment.service;

import com.ecommerce.demo.payment.model.PaymentProvider;
import com.ecommerce.demo.payment.model.PaymentRequest;
import com.ecommerce.demo.payment.model.PaymentResponse;

/**
 * Implementing this interface for connecting each 3nd-party
 */
public interface PaymentConnector {

  PaymentResponse pay(PaymentProvider provider, PaymentRequest request);
}
