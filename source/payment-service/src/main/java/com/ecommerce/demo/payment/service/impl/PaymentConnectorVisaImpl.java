package com.ecommerce.demo.payment.service.impl;

import com.ecommerce.demo.payment.adapter.PaymentAdapterRegistry;
import com.ecommerce.demo.payment.adapter.visa.VisaPaymentAdapter;
import com.ecommerce.demo.payment.model.PaymentProvider;
import com.ecommerce.demo.payment.model.PaymentRequest;
import com.ecommerce.demo.payment.model.PaymentResponse;
import com.ecommerce.demo.payment.service.PaymentConnector;
import com.ecommerce.demo.payment.service.connector.VisaFeignConnector;
import org.springframework.stereotype.Component;

@Component
public class PaymentConnectorVisaImpl implements PaymentConnector {

  private final PaymentAdapterRegistry paymentAdapterRegistry;
  private final VisaFeignConnector visaFeignConnector;

  public PaymentConnectorVisaImpl(PaymentAdapterRegistry paymentAdapterRegistry,
                                  VisaFeignConnector visaFeignConnector) {
    this.paymentAdapterRegistry = paymentAdapterRegistry;
    this.visaFeignConnector = visaFeignConnector;
  }

  @Override
  public PaymentResponse pay(PaymentProvider provider, PaymentRequest request) {
    var visaAdapter = paymentAdapterRegistry.getAdapter(provider.getProvider(), VisaPaymentAdapter.class);
    var res = visaFeignConnector.pay(visaAdapter.buildRequest(request));
    return visaAdapter.extractResponse(res);
  }
}
