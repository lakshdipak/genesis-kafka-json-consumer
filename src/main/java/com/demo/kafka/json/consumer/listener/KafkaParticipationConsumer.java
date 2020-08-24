package com.demo.kafka.json.consumer.listener;


import com.demo.kafka.json.consumer.dto.MessageValue;
import com.demo.kafka.json.consumer.factory.MessageProcessorsFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaParticipationConsumer {

  private MessageProcessorsFactory messageProcessorsFactory;

  @Autowired
  public KafkaParticipationConsumer(MessageProcessorsFactory messageProcessorsFactory) {
    this.messageProcessorsFactory = messageProcessorsFactory;
  }

  @KafkaListener(topics = "${spring.kafka.consumer.topics}", groupId = "${spring.kafka.consumer.group-id}")
  public void listen(ConsumerRecord<String, MessageValue> record) {
    log.info("Received message with key={}, MessageType={} from topic={}, from partition={}, on offset={}",
            record.key(),
            record.value().getProductId(),
            record.topic(),
            record.partition(),
            record.offset());
    try {
      messageProcessorsFactory.createStrategy(record.value().getMessageType())
              .processMessage(record.value());
    } catch (Exception e) {
      log.error("Error occured during processing a message with key={}, eventName={}, topic={}, " +
                      "partition={}, offset={}", record.key(),
              record.value().getMessageType(),
              record.topic(),
              record.partition(),
              record.offset(), e);
      throw e;
    }
  }
}
