package com.ljy.springbootteststudy.services.post;

import com.ljy.springbootteststudy.services.post.application.PostRepository;
import com.ljy.springbootteststudy.services.post.domain.MockPost;
import com.ljy.springbootteststudy.services.post.domain.Post;

import java.util.ArrayList;
import java.util.List;

public class StubPostRepository implements PostRepository {
    private final List<Post> repo = new ArrayList<>();

    @Override
    public Post save(Post post) {
        MockPost mockPost = MockPost.from(post);
        repo.add(mockPost);
        return mockPost;
    }
}
