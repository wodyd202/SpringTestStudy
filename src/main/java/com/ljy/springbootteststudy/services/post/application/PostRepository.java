package com.ljy.springbootteststudy.services.post.application;

import com.ljy.springbootteststudy.services.post.domain.Post;

public interface PostRepository {
    Post save(Post post);
}
