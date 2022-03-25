package com.ljy.springbootteststudy.services.core.event;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ljy.springbootteststudy.services.core.event.infrastructure.KafkaProducer;
import com.ljy.springbootteststudy.services.post.application.event.RegisteredPostEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApplicationEventListener {
    private final ObjectMapper objectMapper;
    private final KafkaProducer kafkaProducer;

    @EventListener
    protected void handle(RegisteredPostEvent event) throws Exception {
        kafkaProducer.send("post.registered-post", objectMapper.writeValueAsString(event));
    }
}
