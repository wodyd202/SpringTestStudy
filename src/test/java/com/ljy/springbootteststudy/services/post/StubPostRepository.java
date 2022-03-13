package com.ljy.springbootteststudy.services.post;

import com.ljy.springbootteststudy.services.post.application.PostRepository;
import com.ljy.springbootteststudy.services.post.application.PostResource;
import com.ljy.springbootteststudy.services.post.domain.MockPost;
import com.ljy.springbootteststudy.services.post.domain.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StubPostRepository implements PostRepository {
    private final List<Post> repo = new ArrayList<>();

    @Override
    public Post save(Post post) {
        MockPost mockPost = MockPost.from(post);
        repo.add(mockPost);
        return mockPost;
    }

    @Override
    public Optional<PostResource> findById(long postId) {
        for (Post post : repo) {
            if(post.getId() == postId){
                return Optional.of(PostResource.from(post));
            }
        }
        return Optional.empty();
    }
}
