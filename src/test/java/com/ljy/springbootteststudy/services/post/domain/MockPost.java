package com.ljy.springbootteststudy.services.post.domain;

import java.util.concurrent.atomic.AtomicLong;

public class MockPost extends Post {
    private static final AtomicLong ATOMIC_LONG = new AtomicLong();

    private MockPost(Long id, String title, String content, String writer){
        super(title, content, writer);
        this.id = id;
    }

    public static MockPost from(Post post) {
        return new MockPost(ATOMIC_LONG.getAndIncrement(), post.getTitle(), post.getContent(), post.getWriter());
    }
}
