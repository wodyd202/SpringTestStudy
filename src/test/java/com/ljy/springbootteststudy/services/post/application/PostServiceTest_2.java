package com.ljy.springbootteststudy.services.post.application;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class PostServiceTest_2 {

    @MockBean
    PostService postService;

    @Test
    void 게시글_정보_조회() {
        when(postService.getPost(1L))
        .thenReturn(new PostResource(1L, "title", "content", "writer"));

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
