package com.ecommerce.demo.payment.service;

import com.ecommerce.demo.payment.entity.TransactionEntity;
import com.ecommerce.demo.payment.message.TransactionMessageProducer;
import com.ecommerce.demo.payment.model.OrderInfo;
import com.ecommerce.demo.payment.model.PaymentRequest;
import com.ecommerce.demo.payment.model.PaymentStatus;
import com.ecommerce.demo.payment.model.TransactionItem;
import com.ecommerce.demo.payment.model.TransactionOperation;
import com.ecommerce.demo.payment.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PaymentService {

  private final TransactionRepository transactionRepository;
  private final TransactionMessageProducer transactionMessageProducer;

  public PaymentService(TransactionRepository transactionRepository,
                        TransactionMessageProducer transactionMessageProducer) {
    this.transactionRepository = transactionRepository;
    this.transactionMessageProducer = transactionMessageProducer;
  }

  public void createPayment(PaymentRequest request) {
    var transactionId = generateTransactionId();
    transactionRepository.save(buildTransactionEntity(transactionId, request));
    transactionMessageProducer.sendTransaction(TransactionOperation.INSERT, buildTransactionItem(transactionId, request));
  }

  public Boolean updatePayment(String transactionId, PaymentStatus status) {
    var entity = transactionRepository.findFirstByTransactionId(transactionId);
    if(entity != null) {
      entity.setStatus(status);
      transactionRepository.save(entity);
      transactionMessageProducer.sendTransaction(TransactionOperation.UPDATE, TransactionItem.builder()
          .amount(entity.getAmount())
          .purchaseTime(entity.getPurchaseTime())
          .status(status)
          .userId(entity.getUserId())
          .transactionId(transactionId)
          //.orderInfo(OrderInfo.builder().build())
          .build());
      return true;
    }
    return false;
  }

  private TransactionEntity buildTransactionEntity(String id, PaymentRequest request) {
    return TransactionEntity.builder()
        .amount(request.getAmount())
        .purchaseTime(request.getPurchaseTime())
        .status(PaymentStatus.IN_PROGRESS)
        .userId(request.getUserId())
        .transactionId(id)
        .build();
  }

  private TransactionItem buildTransactionItem(String id, PaymentRequest request) {
    return TransactionItem.builder()
        .amount(request.getAmount())
        .purchaseTime(request.getPurchaseTime())
        .status(PaymentStatus.IN_PROGRESS)
        .userId(request.getUserId())
        .transactionId(id)
        //.orderInfo(request.getOrderInfo())
        .build();
  }

  private String generateTransactionId() {
    Random random = new Random(System.nanoTime());
    int generatedTransactionId = random.nextInt(1000000000);
    return Integer.toString(generatedTransactionId);
  }
}
