package com.ljy.springbootteststudy.services.post.infrastructure;

import com.ljy.springbootteststudy.services.post.DataQuerydslTest;
import com.ljy.springbootteststudy.services.post.application.PostRepository;
import com.ljy.springbootteststudy.services.post.application.PostResource;
import com.ljy.springbootteststudy.services.post.domain.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataQuerydslTest
class PostRepositoryTest {
    @Autowired
    PostRepository postRepository;

    @Test
    void 게시글_단건_조회(){
        // given
        Post post = Post.of("title", "content", "writer");
        post = postRepository.save(post);

        // when
        PostResource postResource = postRepository.findById(post.getId()).get();

        // then
        assertNotNull(postResource);
    }
}
