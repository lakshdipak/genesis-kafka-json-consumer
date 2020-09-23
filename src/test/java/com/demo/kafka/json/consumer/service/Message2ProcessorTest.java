package com.demo.kafka.json.consumer.service;

import com.demo.kafka.json.consumer.constants.MessageType;
import com.demo.kafka.json.consumer.dto.MessageValue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class Message2ProcessorTest {



  /*@Spy
  private EventPayloadMapper eventPayloadMapper;
*/
  @InjectMocks
  private Message2Processor message2Processor;

  @Test
  public void testProcessMessage() {
     final String keyPrefix = "TEST_EVENT:";
    final MessageValue messageValue = new MessageValue();
    messageValue.setMessageType(MessageType.Message2);
    message2Processor.processMessage(messageValue);


    //verify(xxx);
  }
}