package com.ecommerce.demo.order.message;

import com.ecommerce.demo.order.entity.OrderEntity;
import com.ecommerce.demo.order.model.TransactionMessage;
import com.ecommerce.demo.order.model.TransactionOperation;
import com.ecommerce.demo.order.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TransactionMessageConsumer {

  private final AmqpTemplate amqpTemplate;
  private final OrderRepository orderRepository;

  public TransactionMessageConsumer(AmqpTemplate amqpTemplate,
                                    OrderRepository orderRepository) {
    this.amqpTemplate = amqpTemplate;
    this.orderRepository = orderRepository;
  }

  @RabbitListener(queues = "${spring.rabbitmq.transaction-queue-name}")
  public void listenTransactionQueue(TransactionMessage message) {
    log.info("Received message: {}", message);
    var messageEntity = OrderEntity.builder()
        .amount(message.getPayload().getAmount())
        .transactionId(message.getPayload().getTransactionId())
        .purchaseTime(message.getPayload().getPurchaseTime())
        .status(message.getPayload().getStatus())
        .userId(message.getPayload().getUserId())
        .build();

    if(TransactionOperation.UPDATE.equals(message.getOperation())) {
      var tran = orderRepository.findFirstByTransactionId(message.getPayload().getTransactionId());
      if(tran == null) {
        throw new AmqpRejectAndDontRequeueException("transaction not existed");
      }
      messageEntity.setId(tran.getId());
    }

    orderRepository.save(messageEntity);

  }
}
