package com.ljy.springbootteststudy.web.post;

import com.ljy.springbootteststudy.services.post.application.WritePostDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WritePostRequest {
    @NotBlank
    private String title;
    @NotBlank
    private String content;

    public static WritePostRequest of(String title, String content) {
        return new WritePostRequest(title, content);
    }

    public WritePostDto toDto() {
        return WritePostDto.of(title, content);
    }
}
