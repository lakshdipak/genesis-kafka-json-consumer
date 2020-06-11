package com.citi.genesis.api.consumer.strategy;

public abstract class MessageProcessorStrategy {

  abstract public void processMessage(Object message);
}
