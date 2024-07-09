package com.example.consumer.consumer;

import com.example.consumer.consumer.event.PatientEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.jupiter.api.*;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.kafka.test.utils.KafkaTestUtils;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;

//@EmbeddedKafka
//@SpringBootTest(properties = "spring.kafka.bootstrap-servers=${spring.embedded.kafka.brokers}")
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//@EnableAutoConfiguration(exclude= FlywayAutoConfiguration.class)
class PatientConsumerTest {

//    private final String TOPIC_NAME = "com.madadipouya.kafka.user";
//
//    private Producer<String, String> producer;
//
//    @Autowired
//    private EmbeddedKafkaBroker embeddedKafkaBroker;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @SpyBean
//    private PatientConsumer patientConsumer;
//
//    @Captor
//    ArgumentCaptor<PatientEvent> patientEventArgumentCaptor;
//
//    @Captor
//    ArgumentCaptor<String> topicArgumentCaptor;
//
//    @Captor
//    ArgumentCaptor<Integer> partitionArgumentCaptor;
//
//    @Captor
//    ArgumentCaptor<Long> offsetArgumentCaptor;
//
//    @BeforeAll
//    void setUp() {
//        Map<String, Object> configs = new HashMap<>(KafkaTestUtils.producerProps(embeddedKafkaBroker));
//        producer = new DefaultKafkaProducerFactory<>(configs, new StringSerializer(), new StringSerializer()).createProducer();
//    }
//
//    @Test
//    void testLogKafkaMessages() throws JsonProcessingException {
//        String uuid = "11111";
//        PatientEvent event = new PatientEvent(1L, "Paciente 001", "03368837060", LocalDate.now());
//        String message = objectMapper.writeValueAsString(event);
//        producer.send(new ProducerRecord<>(TOPIC_NAME, 0, uuid, message));
//        producer.flush();
//
//        verify(patientConsumer, timeout(5000).times(1))
//                .consumeMessage(patientEventArgumentCaptor.capture());
//
//        PatientEvent patientEvent = patientEventArgumentCaptor.getValue();
//    }
//
//
//    @AfterAll
//    void shutdown() {
//        producer.close();
//    }
}
