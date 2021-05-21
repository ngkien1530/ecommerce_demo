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
public class TransactionItem {

  private BigInteger id;
  private BigInteger userId;
  private BigDecimal amount;
  private String transactionId;
  private PaymentStatus status;
  private String statusReadable;
  private Date purchaseTime;
  private OrderInfo orderInfo;
}
