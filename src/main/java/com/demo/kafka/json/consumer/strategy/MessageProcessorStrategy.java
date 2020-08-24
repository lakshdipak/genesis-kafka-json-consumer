package com.demo.kafka.json.consumer.strategy;

public abstract class MessageProcessorStrategy {

  abstract public void processMessage(Object message);
}
