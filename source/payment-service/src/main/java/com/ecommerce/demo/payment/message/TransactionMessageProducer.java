package com.ecommerce.demo.payment.message;

import com.ecommerce.demo.payment.model.TransactionItem;
import com.ecommerce.demo.payment.model.TransactionMessage;
import com.ecommerce.demo.payment.model.TransactionOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TransactionMessageProducer {

  @Value("${spring.rabbitmq.transaction-queue-name}")
  private String TRANSACTION_QUEUE;

  @Autowired
  private AmqpTemplate amqpTemplate;

  public void sendTransaction(TransactionOperation operation, TransactionItem transactionItem) {
    log.info("Send to amqp: {}", transactionItem);
    var payload = TransactionMessage.TransactionPayload.builder()
        .amount(transactionItem.getAmount())
        .transactionId(transactionItem.getTransactionId())
        .purchaseTime(transactionItem.getPurchaseTime())
        .status(transactionItem.getStatus())
        .userId(transactionItem.getUserId())
        //.orderInfo(transactionItem.getOrderInfo())
        .build();
    var message = TransactionMessage.builder()
        .operation(operation).payload(payload).build();

    amqpTemplate.convertAndSend(TRANSACTION_QUEUE, message);
  }
}
