package com.demo.kafka.json.consumer.listener;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.TopicPartition;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.listener.ConsumerAwareErrorHandler;
import org.springframework.kafka.support.serializer.DeserializationException;

public class DeserializationErrorSkipHandler implements ConsumerAwareErrorHandler {
    private static final Logger LOGGER = LogManager.getLogger(DeserializationErrorSkipHandler.class);

    @Override
    public void handle(Exception thrownException, ConsumerRecord<?, ?> data, Consumer<?, ?> consumer) {
        LOGGER.error("Error during message processing.", thrownException);
        if (thrownException instanceof DeserializationException) {
            LOGGER.error(
                    "Unable to deserialize message from topic {}, in partition {}, on offset {}. Unrecoverable error, seeking past failed offset",
                    data.topic(), data.partition(), data.offset());
            consumer.seek(new TopicPartition(data.topic(), data.partition()), data.offset() + 1);
        }
    }
}
