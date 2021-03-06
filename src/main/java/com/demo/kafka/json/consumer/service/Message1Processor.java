package com.demo.kafka.json.consumer.service;


import com.demo.kafka.json.consumer.strategy.MessageProcessorStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("Message1")
@Slf4j
public class Message1Processor extends MessageProcessorStrategy {


  @Autowired
  public Message1Processor() {

  }


  @Override
  public void processMessage(Object message) {

    log.info("Processing Actual Logic object with id={}"," Call the actual Service" );
  }
}
