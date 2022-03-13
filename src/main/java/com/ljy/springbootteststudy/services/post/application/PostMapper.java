package com.ljy.springbootteststudy.services.post.application;

import com.ljy.springbootteststudy.services.post.domain.Post;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {

    public Post mapOf(WritePostDto writePostDto, String writer){
        return Post.of(
                writePostDto.getTitle(),
                writePostDto.getContent(),
                writer
        );
    }
}
