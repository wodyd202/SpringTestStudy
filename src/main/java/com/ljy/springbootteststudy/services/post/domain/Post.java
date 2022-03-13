package com.ljy.springbootteststudy.services.post.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String title;
    private String content;
    private String writer;

    @CreatedDate
    private LocalDateTime createDateTime;

    @LastModifiedDate
    private LocalDateTime lastModifiedDateTime;

    Post(String title, String content, String writer){
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    public static Post of(String title, String content, String writer) {
        return new Post(title, content, writer);
    }
}
