package com.ecommerce.demo.transaction.message;

import com.ecommerce.demo.transaction.entity.TransactionEntity;
import com.ecommerce.demo.transaction.model.TransactionMessage;
import com.ecommerce.demo.transaction.model.TransactionOperation;
import com.ecommerce.demo.transaction.repository.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TransactionMessageConsumer {

  private final AmqpTemplate amqpTemplate;
  private final TransactionRepository transactionRepository;

  public TransactionMessageConsumer(AmqpTemplate amqpTemplate,
                                    TransactionRepository transactionRepository) {
    this.amqpTemplate = amqpTemplate;
    this.transactionRepository = transactionRepository;
  }

  @RabbitListener(queues = "${spring.rabbitmq.transaction-queue-name}")
  public void listenTransactionQueue(TransactionMessage message) {
    log.info("Received message: {}", message);

    if(TransactionOperation.INSERT.equals(message.getOperation()) ||
       TransactionOperation.UPDATE.equals(message.getOperation())) {
      var messageEntity = TransactionEntity.builder()
          .id(message.getPayload().getId())
          .amount(message.getPayload().getAmount())
          .transactionId(message.getPayload().getTransactionId())
          .purchaseTime(message.getPayload().getPurchaseTime())
          .status(message.getPayload().getStatus())
          .userId(message.getPayload().getUserId())
          .build();
      transactionRepository.save(messageEntity);
    }
  }
}
