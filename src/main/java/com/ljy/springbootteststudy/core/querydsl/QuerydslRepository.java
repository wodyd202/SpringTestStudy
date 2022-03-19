package com.ljy.springbootteststudy.core.querydsl;

import org.springframework.stereotype.Repository;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Repository
public @interface QuerydslRepository {
}
