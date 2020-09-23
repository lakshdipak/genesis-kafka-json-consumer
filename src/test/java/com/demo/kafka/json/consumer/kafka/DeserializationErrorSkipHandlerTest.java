package com.demo.kafka.json.consumer.kafka;

import com.demo.kafka.json.consumer.listener.DeserializationErrorSkipHandler;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.TopicPartition;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.kafka.support.serializer.DeserializationException;

@RunWith(MockitoJUnitRunner.class)
public class DeserializationErrorSkipHandlerTest {

    private static DeserializationErrorSkipHandler skipHandler = new DeserializationErrorSkipHandler();

    @Test
    public void should_Seek_To_New_Offset() {
        Exception deserException = new DeserializationException("TEST MESSAGE", new byte[0], Boolean.FALSE, new Exception());
        final Consumer mockConsumer = Mockito.mock(Consumer.class);
        String topic = "TEST_TOPIC";
        int partition = 1;
        int offset = 1;
        ConsumerRecord<?, ?> testRecord = new ConsumerRecord<Object, Object>(
                topic, partition, offset, new Object(), new Object()
        );
        skipHandler.handle(deserException, testRecord, mockConsumer);
        Mockito.verify(mockConsumer, Mockito.times(1)).seek(new TopicPartition(topic, partition), offset+1);
    }
}