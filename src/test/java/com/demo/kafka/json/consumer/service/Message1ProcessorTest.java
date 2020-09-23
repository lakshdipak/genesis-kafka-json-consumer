package com.demo.kafka.json.consumer.service;

import com.demo.kafka.json.consumer.constants.MessageType;
import com.demo.kafka.json.consumer.dto.MessageValue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class Message1ProcessorTest {



  /*@Spy
  private EventPayloadMapper eventPayloadMapper;
*/
  @InjectMocks
  private Message1Processor message1Processor;

  @Test
  public void testProcessMessage() {
     final String keyPrefix = "TEST_EVENT:";
    final MessageValue messageValue = new MessageValue();
    messageValue.setMessageType(MessageType.Message1);
    message1Processor.processMessage(messageValue);
    //verify(messageValue, times(1)).getMessageType();

    //verify(xxx);
  }
}