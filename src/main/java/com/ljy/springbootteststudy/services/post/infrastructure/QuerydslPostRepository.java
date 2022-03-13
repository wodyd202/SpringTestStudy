package com.ljy.springbootteststudy.services.post.infrastructure;

import com.ljy.springbootteststudy.services.post.application.PostRepository;
import com.ljy.springbootteststudy.services.post.domain.Post;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class QuerydslPostRepository implements PostRepository {
    @PersistenceContext
    private EntityManager entityManager;

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
