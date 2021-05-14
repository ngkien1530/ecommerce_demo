package com.ecommerce.demo.transaction.model;

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
    private BigInteger id;
    private BigInteger userId;
    private BigDecimal amount;
    private String transactionId;
    private TransactionStatus status;
    private Date purchaseTime;
  }
}
