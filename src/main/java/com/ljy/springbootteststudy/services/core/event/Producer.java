package com.ljy.springbootteststudy.services.core.event;

public interface Producer {
    void send(String topic, String payload);
}
