package com.ecommerce.demo.payment.entity;

import com.ecommerce.demo.payment.model.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TransactionEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private BigInteger id;

  @Column(name = "user_id")
  private BigInteger userId;

  @Column(name = "transaction_id")
  private String transactionId;

  @Column(name = "amount")
  private BigDecimal amount;

  @Column(name = "payment_status")
  private PaymentStatus status;

  @Column(name = "purchase_time")
  private Date purchaseTime;

}
