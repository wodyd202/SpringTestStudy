package com.ljy.springbootteststudy.services.post.application;

import com.ljy.springbootteststudy.services.post.domain.Post;
import lombok.Getter;

@Getter
public class PostResource {
    private long id;
    private String title;
    private String content;
    private String writer;

    public PostResource(long id, String title, String content, String writer) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    public static PostResource from(Post post) {
        return new PostResource(post.getId(),
                                post.getTitle(),
                                post.getContent(),
                                post.getWriter());
    }
}
