package com.ecommerce.demo.transaction.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

@Data
@Builder
public class TransactionItem {

  private BigInteger id;
  private BigInteger userId;
  private BigDecimal amount;
  private String transactionId;
  private TransactionStatus status;
  private Date purchaseTime;
}
