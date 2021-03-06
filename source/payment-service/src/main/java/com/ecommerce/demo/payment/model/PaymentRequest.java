package com.ecommerce.demo.payment.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {
  private BigDecimal amount;
  private PaymentMethod method;
  private BigInteger userId;
  private Date purchaseTime;
  private String paymentCardId;
  private OrderInfo orderInfo;
}
