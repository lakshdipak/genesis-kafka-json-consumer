package com.citi.genesis.api.consumer.factory;


import com.citi.genesis.api.dto.constants.MessageType;
import com.citi.genesis.api.consumer.strategy.MessageProcessorStrategy;

public interface MessageProcessorsFactory {

  MessageProcessorStrategy createStrategy(MessageType messageType);
}
