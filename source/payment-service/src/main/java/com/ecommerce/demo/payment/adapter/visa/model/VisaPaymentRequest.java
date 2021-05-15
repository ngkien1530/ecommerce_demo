package com.ecommerce.demo.payment.adapter.visa.model;

import com.ecommerce.demo.payment.adapter.ThirdPartyPaymentRequest;
import com.ecommerce.demo.payment.model.PaymentProvider;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class VisaPaymentRequest implements ThirdPartyPaymentRequest {

  private BigDecimal amount;
}
