package com.ljy.springbootteststudy.services.post.application;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PostServiceTest_1 {

    @Mock
    PostRepository postRepository;

    @InjectMocks
    PostService postService;

    @Test
    void 게시글_조회시_존재하지_않을_경우() {
        // given
        when(postRepository.findById(1L))
        .thenReturn(Optional.empty());

        // when
        assertThrows(PostNotFoundException.class,() -> {
            postService.getPost(1L);
        });
    }
}
