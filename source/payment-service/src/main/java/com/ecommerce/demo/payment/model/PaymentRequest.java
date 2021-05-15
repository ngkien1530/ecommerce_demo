package com.ecommerce.demo.payment.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class PaymentRequest {
  private BigDecimal amount;

}
