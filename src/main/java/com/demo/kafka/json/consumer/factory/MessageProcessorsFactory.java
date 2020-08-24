package com.demo.kafka.json.consumer.factory;




import com.demo.kafka.json.consumer.constants.MessageType;
import com.demo.kafka.json.consumer.strategy.MessageProcessorStrategy;

public interface MessageProcessorsFactory {

  MessageProcessorStrategy createStrategy(MessageType messageType);
}
