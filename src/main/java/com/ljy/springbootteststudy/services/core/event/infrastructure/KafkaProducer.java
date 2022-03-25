package com.ljy.springbootteststudy.services.core.event.infrastructure;

import com.ljy.springbootteststudy.services.core.event.Producer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaProducer implements Producer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void send(String topic, String payload) {
        kafkaTemplate.send(topic, payload);
    }
}
