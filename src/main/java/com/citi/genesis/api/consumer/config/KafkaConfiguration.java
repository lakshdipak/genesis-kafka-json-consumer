package com.citi.genesis.api.consumer.config;


import com.citi.genesis.api.dto.sample.MessageValue;
import com.citi.genesis.api.consumer.listener.DeserializationErrorSkipHandler;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer2;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaConfiguration {

    @Value("${spring.kafka.consumer.concurrency-factor}")
    private int concurrencyFactor;

    private ConsumerFactory<String, MessageValue> consumerFactory;

    KafkaConfiguration(ConsumerFactory consumerFactory) {
        this.consumerFactory = consumerFactory;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, MessageValue>
    kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, MessageValue> containerFactory
                = new ConcurrentKafkaListenerContainerFactory<>();
        containerFactory.setErrorHandler(new DeserializationErrorSkipHandler());
        containerFactory.setConcurrency(concurrencyFactor);
        Map<String, Object> configMap = new HashMap<>();
        configMap.putAll(this.consumerFactory.getConfigurationProperties());
        prepareDeserializers(configMap);
        ConsumerFactory<String, MessageValue> factory = new DefaultKafkaConsumerFactory<>(configMap);
        containerFactory.setConsumerFactory(factory);
        return containerFactory;
    }

    private void prepareDeserializers(Map<String, Object> configMap) {
        /*configMap.put(ErrorHandlingDeserializer.KEY_DESERIALIZER_CLASS, String.class.getName());
        configMap.put(ErrorHandlingDeserializer.VALUE_DESERIALIZER_CLASS, JsonDeserializer.class.getName());
        configMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class);
        configMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class);*/
    }

}
