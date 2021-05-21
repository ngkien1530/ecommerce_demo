package com.ecommerce.demo.payment.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionMessage {
  private TransactionOperation operation;
  private TransactionPayload payload;

  @Builder
  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  public static class TransactionPayload {
    private BigInteger userId;
    private BigDecimal amount;
    private String transactionId;
    private PaymentStatus status;
    private Date purchaseTime;
    //private OrderInfo orderInfo;
  }
}
