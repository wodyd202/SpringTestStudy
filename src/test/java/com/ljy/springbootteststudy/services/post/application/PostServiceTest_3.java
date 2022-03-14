package com.ljy.springbootteststudy.services.post.application;

import com.ljy.springbootteststudy.services.post.StubPostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

class PostServiceTest_3 {

    PostRepository postRepository;
    PostService postService;

    @BeforeEach
    void setUp(){
        postRepository = spy(new StubPostRepository());
        postService = new PostService(postRepository, new PostMapper());
    }

    @Test
    void 게시글_정보_조회() {
        when(postRepository.findById(1L))
        .thenReturn(Optional.of(new PostResource(1L, "title", "content", "writer")));

        // when
        PostResource postResource = postService.getPost(1L);

        // then
        assertNotNull(postResource);
        assertEquals(postResource.getId(), 1L);
        assertEquals(postResource.getTitle(), "title");
        assertEquals(postResource.getContent(), "content");
        assertEquals(postResource.getWriter(), "writer");
    }
}
