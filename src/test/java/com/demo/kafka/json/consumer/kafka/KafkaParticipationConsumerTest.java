package com.demo.kafka.json.consumer.kafka;


import com.demo.kafka.json.consumer.constants.MessageType;
import com.demo.kafka.json.consumer.dto.MessageKey;
import com.demo.kafka.json.consumer.dto.MessageValue;
import com.demo.kafka.json.consumer.factory.MessageProcessorsFactory;
import com.demo.kafka.json.consumer.listener.KafkaParticipationConsumer;
import com.demo.kafka.json.consumer.service.Message1Processor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class KafkaParticipationConsumerTest {

  @Spy
  private MessageProcessorsFactory messageProcessorsFactory;

  @InjectMocks
  private KafkaParticipationConsumer kafkaParticipationConsumer;

  @Before
  public void setUp() {
    Message1Processor message1Processor = Mockito.mock(Message1Processor.class);
    when(messageProcessorsFactory.createStrategy(any(MessageType.class)))
            .thenReturn(message1Processor);
  }

  @Test
  public void testListener() {
    MessageKey messageKey = MessageKey.newBuilder();
    MessageValue messageValue = new MessageValue();
    messageValue.setMessageType(MessageType.Message1);

    ConsumerRecord<String, MessageValue> masterRecord =
            new ConsumerRecord<>("TOPIC", 0, 0, messageKey.getProductId(), messageValue);
    kafkaParticipationConsumer.listen(masterRecord);

    verify(messageProcessorsFactory, times(1))
            .createStrategy(messageValue.getMessageType());
  }
}
