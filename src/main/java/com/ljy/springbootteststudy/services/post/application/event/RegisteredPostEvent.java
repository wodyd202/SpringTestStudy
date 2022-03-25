package com.ljy.springbootteststudy.services.post.application.event;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RegisteredPostEvent {
    private long id;

    public static RegisteredPostEvent idOf(long id) {
        return new RegisteredPostEvent(id);
    }

    @Override
    public String toString() {
        return "RegisteredPostEvent{" +
                "id=" + id +
                '}';
    }
}
