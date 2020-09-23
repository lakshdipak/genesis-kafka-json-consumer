package com.demo.kafka.json.consumer.service;


import com.demo.kafka.json.consumer.strategy.MessageProcessorStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("Message2")
@Slf4j
public class Message2Processor extends MessageProcessorStrategy {


  @Autowired
  public Message2Processor() {

  }


  @Override
  public void processMessage(Object message) {

    log.info("Processing Actual Logic object with id={}"," Call the actual Service" );
  }
}
