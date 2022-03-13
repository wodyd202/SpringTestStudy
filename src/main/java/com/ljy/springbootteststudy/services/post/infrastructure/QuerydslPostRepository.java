package com.ljy.springbootteststudy.services.post.infrastructure;

import com.ljy.springbootteststudy.domain.QPost;
import com.ljy.springbootteststudy.services.post.application.PostRepository;
import com.ljy.springbootteststudy.services.post.application.PostResource;
import com.ljy.springbootteststudy.services.post.domain.Post;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

import static com.ljy.springbootteststudy.domain.QPost.post;

@Repository
@RequiredArgsConstructor
public class QuerydslPostRepository implements PostRepository {
    @PersistenceContext
    private EntityManager entityManager;
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Optional<PostResource> findById(long postId) {
        PostResource postResource = jpaQueryFactory.select(Projections.constructor(PostResource.class))
                .from(post)
                .where(post.id.eq(postId))
                .fetchFirst();
        return Optional.ofNullable(postResource);
    }

    @Override
    @Transactional
    public Post save(Post post) {
        if(entityManager.contains(post)){
            entityManager.merge(post);
            return post;
        }
        entityManager.persist(post);
        return post;
    }
}
