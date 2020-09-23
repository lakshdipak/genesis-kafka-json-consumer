package com.demo.kafka.json.consumer.service;

import com.demo.kafka.json.consumer.constants.MessageType;
import com.demo.kafka.json.consumer.dto.MessageValue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SampleServiceTest {



  /*@Spy
  private EventPayloadMapper eventPayloadMapper;
*/
  @InjectMocks
  private SampleProcessor sampleService;

  @Test
  public void testProcessMessage() {
     final String keyPrefix = "TEST_EVENT:";
    final MessageValue messageValue = new MessageValue();
    messageValue.setMessageType(MessageType.Message1);
    when(messageValue.getMessageType()).thenReturn(MessageType.Message1);

    //verify(xxx);
  }
}