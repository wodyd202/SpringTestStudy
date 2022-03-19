package com.ljy.springbootteststudy.services.post;

import com.ljy.springbootteststudy.SpringBootTestStudyApplication;
import com.ljy.springbootteststudy.core.querydsl.QuerydslRepository;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.properties.PropertyMapping;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@DataJpaTest(properties = {
        "spring.jpa.properties.hibernate.format_sql=true"
})
@ComponentScan(
        useDefaultFilters = false,
        includeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.ANNOTATION,
                        classes = { QuerydslRepository.class }
                )
        },
        basePackageClasses = SpringBootTestStudyApplication.class
)
public @interface DataQuerydslTest {
}
