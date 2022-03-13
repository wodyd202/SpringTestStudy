package com.ljy.springbootteststudy.services.post.application;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class WritePostDto {
    private final String title;
    private final String content;

    public static WritePostDto of(final String title,
                                  final String content) {
        return new WritePostDto(title, content);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WritePostDto that = (WritePostDto) o;
        return Objects.equals(title, that.title) && Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, content);
    }
}
