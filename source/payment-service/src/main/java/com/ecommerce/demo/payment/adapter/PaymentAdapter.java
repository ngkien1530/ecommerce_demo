package com.ecommerce.demo.payment.adapter;

import com.ecommerce.demo.payment.model.PaymentProvider;
import com.ecommerce.demo.payment.model.PaymentRequest;
import com.ecommerce.demo.payment.model.PaymentResponse;

public interface PaymentAdapter<K, V> {
  String getProvider();
  K buildRequest(PaymentRequest request);
  PaymentResponse extractResponse(V response);
}
