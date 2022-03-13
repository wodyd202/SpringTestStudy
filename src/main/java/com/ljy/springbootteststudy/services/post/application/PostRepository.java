package com.ljy.springbootteststudy.services.post.application;

import com.ljy.springbootteststudy.services.post.domain.Post;

import java.util.Optional;

public interface PostRepository {
    Post save(Post post);
    Optional<PostResource> findById(long postId);
}
