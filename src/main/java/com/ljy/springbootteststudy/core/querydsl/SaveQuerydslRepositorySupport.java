package com.ljy.springbootteststudy.core.querydsl;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class SaveQuerydslRepositorySupport<T> extends QuerydslRepositorySupport {
    @PersistenceContext
    private EntityManager entityManager;

    protected SaveQuerydslRepositorySupport(Class<?> domainClass) {
        super(domainClass);
    }

    public final T save(T obj){
        if(entityManager.contains(obj)){
            entityManager.merge(obj);
            return obj;
        }
        entityManager.persist(obj);
        return obj;
    }
}
