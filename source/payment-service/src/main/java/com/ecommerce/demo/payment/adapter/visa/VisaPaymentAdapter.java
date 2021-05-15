package com.ecommerce.demo.payment.adapter.visa;

import com.ecommerce.demo.payment.adapter.PaymentAdapter;
import com.ecommerce.demo.payment.adapter.ThirdPartyPaymentRequest;
import com.ecommerce.demo.payment.adapter.ThirdPartyPaymentResponse;
import com.ecommerce.demo.payment.adapter.visa.model.VisaPaymentRequest;
import com.ecommerce.demo.payment.adapter.visa.model.VisaPaymentResponse;
import com.ecommerce.demo.payment.model.PaymentProvider;
import com.ecommerce.demo.payment.model.PaymentRequest;
import com.ecommerce.demo.payment.model.PaymentResponse;

public class VisaPaymentAdapter implements PaymentAdapter<VisaPaymentRequest, VisaPaymentResponse> {

  @Override
  public String getProvider() {
    return PaymentProvider.VISA.getProvider();
  }

  @Override
  public VisaPaymentRequest buildRequest(PaymentRequest request) {
    return null;
  }

  @Override
  public PaymentResponse extractResponse(VisaPaymentResponse response) {
    return null;
  }


}
