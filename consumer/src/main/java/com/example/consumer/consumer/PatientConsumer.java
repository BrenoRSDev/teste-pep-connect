package com.example.consumer.consumer;

import com.example.consumer.consumer.event.PatientEvent;
import com.example.consumer.service.PatientService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static java.util.Objects.nonNull;

@Component
@Log4j2
@AllArgsConstructor
public class PatientConsumer {

    private PatientService service;

    @KafkaListener(topics = "patient-topic", groupId = "patient-group", containerFactory = "jsonContainerFactory")
    public void consumeMessage(@Payload PatientEvent event) {
        log.info("Consumindo do topico patient");
        if(nonNull(event)){
            service.save(event);
        }
    }
}
