package com.ljy.springbootteststudy.services.post.application;

import com.ljy.springbootteststudy.services.post.DataQuerydslTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataQuerydslTest
@Import({PostService.class, PostMapper.class})
class PostServiceTest_5 {

    @Autowired
    PostService postService;

    @Autowired
    PostRepository postRepository;

    @Test
    void 게시글_생성() {
        // when
        WritePostDto writePostDto = WritePostDto.of("title", "content");
        Long postId = postService.write(writePostDto, "writer");

        // then
        assertNotNull(postId);
    }
}
