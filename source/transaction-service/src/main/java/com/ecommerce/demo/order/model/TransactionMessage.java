package com.ecommerce.demo.order.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
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
    @JsonProperty("userId")
    private BigInteger userId;
    @JsonProperty("amount")
    private BigDecimal amount;
    @JsonProperty("transactionId")
    private String transactionId;
    @JsonProperty("status")
    private TransactionStatus status;
    @JsonProperty("purchaseTime")
    private Date purchaseTime;
//    @JsonProperty("orderInfo")
//    private JsonNode orderInfo;
  }
}
