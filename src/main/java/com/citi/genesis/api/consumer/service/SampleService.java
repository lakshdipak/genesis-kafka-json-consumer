package com.citi.genesis.api.consumer.service;


import com.citi.genesis.api.consumer.strategy.MessageProcessorStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("Message1")
@Slf4j
public class SampleService extends MessageProcessorStrategy {


  @Autowired
  public SampleService() {

  }


  @Override
  public void processMessage(Object message) {

    log.info("Processing Actual Logic object with id={}"," Call the actual Service" );
  }
}
