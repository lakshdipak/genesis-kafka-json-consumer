package com.demo.kafka.json.consumer.kafka;

import com.adidas.estudio.dto.masterdata.MasterMessageKey;
import com.adidas.estudio.dto.masterdata.MasterMessageValue;
import com.adidas.estudio.dto.masterdata.MetadataEventName;
import com.adidas.estudio.factory.MessageProcessorsFactory;
import com.adidas.estudio.mock.masterdata.MasterDataMessageFactory;
import com.adidas.estudio.service.CommunityProcessor;
import com.demo.kafka.json.consumer.constants.MessageType;
import com.demo.kafka.json.consumer.dto.MessageKey;
import com.demo.kafka.json.consumer.factory.MessageProcessorsFactory;
import com.demo.kafka.json.consumer.listener.KafkaParticipationConsumer;
import com.demo.kafka.json.consumer.service.SampleService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MasterDataConsumerTest {

  @Spy
  private MessageProcessorsFactory messageProcessorsFactory;

  @InjectMocks
  private KafkaParticipationConsumer kafkaParticipationConsumer;

  @Before
  public void setUp() {
    SampleService sampleProcessor = Mockito.mock(SampleService.class);
    when(messageProcessorsFactory.createStrategy(any(MessageType.class)))
            .thenReturn(sampleProcessor);
  }

  @Test
  public void testListener() {
    MessageKey messageKey = messageProcessorsFactory.createStrategy()createMasterMessageKey();
    MasterMessageValue masterMessageValue =
            MasterDataMessageFactory.createMasterMessageValue(MetadataEventName.CommunityMaster);
    ConsumerRecord<MasterMessageKey, MasterMessageValue> communityMasterRecord =
            new ConsumerRecord<>("TOPIC", 0, 0, masterMessageKey, masterMessageValue);
    masterDataConsumer.listen(communityMasterRecord);

    verify(messageProcessorsFactory, times(1))
            .createStrategy(masterMessageValue.getMetadata().getEventName());
  }
}
