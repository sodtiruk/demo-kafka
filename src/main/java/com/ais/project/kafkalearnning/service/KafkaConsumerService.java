package com.ais.project.kafkalearnning.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(topics = "my-topic", groupId = "my-group")
    public void listen(String message) {
        log.info("Received: {} from group 1", message);
    }

    @KafkaListener(topics = "my-topic", groupId = "my-group-2")
    public void listen2(String message) {
        log.info("Received: {} from group 2", message);
    }


}
