package com.ljy.springbootteststudy.services.postHistory.application;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ljy.springbootteststudy.services.post.application.event.RegisteredPostEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PostEventListener {
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "post.registered-post", groupId = "post-history")
    protected void handle(@Payload String payload, Acknowledgment acknowledgment) throws Exception{
        RegisteredPostEvent event = objectMapper.readValue(payload, RegisteredPostEvent.class);
        log.info("recive event : {}", event);
        acknowledgment.acknowledge();
    }
}
