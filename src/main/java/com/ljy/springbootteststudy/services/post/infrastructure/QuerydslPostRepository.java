package com.ljy.springbootteststudy.services.post.infrastructure;

import com.ljy.springbootteststudy.core.querydsl.QuerydslRepository;
import com.ljy.springbootteststudy.core.querydsl.SaveQuerydslRepositorySupport;
import com.ljy.springbootteststudy.services.post.application.PostRepository;
import com.ljy.springbootteststudy.services.post.application.PostResource;
import com.ljy.springbootteststudy.services.post.domain.Post;

import javax.annotation.PostConstruct;
import java.util.Optional;

import static com.ljy.springbootteststudy.domain.QPost.post;
import static com.querydsl.core.types.Projections.constructor;

@QuerydslRepository
public class QuerydslPostRepository extends SaveQuerydslRepositorySupport<Post> implements PostRepository {
    protected QuerydslPostRepository() {
        super(Post.class);
    }

    @Override
    public Optional<PostResource> findById(long postId) {
        PostResource postResource = from(post)
        .select(constructor(PostResource.class,
                post.id,
                post.title,
                post.content,
                post.writer
        ))
        .where(post.id.eq(postId))
        .fetchFirst();
        return Optional.ofNullable(postResource);
    }
}
