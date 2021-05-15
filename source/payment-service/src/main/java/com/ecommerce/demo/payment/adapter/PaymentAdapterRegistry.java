package com.ecommerce.demo.payment.adapter;

import com.ecommerce.demo.payment.adapter.visa.VisaPaymentAdapter;
import com.ecommerce.demo.payment.model.PaymentRequest;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PaymentAdapterRegistry {
  private final Map<String, PaymentAdapter> adapters = new HashMap<>();

  public PaymentAdapterRegistry() {
  }

  public void registerAdapter(PaymentAdapter adapter) {
    this.adapters.put(adapter.getProvider(), adapter);
  }

  public <T> T getAdapter(String key, Class<T> type) {
    return type.cast(adapters.get(key));
  }
}
