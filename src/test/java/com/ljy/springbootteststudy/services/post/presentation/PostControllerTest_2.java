package com.ljy.springbootteststudy.services.post.presentation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ljy.springbootteststudy.services.post.application.PostNotFoundException;
import com.ljy.springbootteststudy.services.post.application.PostResource;
import com.ljy.springbootteststudy.services.post.application.PostService;
import com.ljy.springbootteststudy.services.post.application.WritePostDto;
import com.ljy.springbootteststudy.web.post.PostController;
import com.ljy.springbootteststudy.web.post.WritePostRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PostController.class)
class PostControllerTest_2 {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private PostService postService;

    @Test
    void 게시글_등록_201() throws Exception {
        // given
        when(postService.write(WritePostDto.of("title", "content"), "user"))
        .thenReturn(1L);

        // when
        WritePostRequest writePostRequest = WritePostRequest.of("title", "content");
        assertWritePostRequest(writePostRequest, "writer")

        // then
        .andExpect(status().isCreated());
    }

    @Test
    void 게시글_등록시_타이틀을_입력하지_않을_경우_400() throws Exception {
        // when
        WritePostRequest writePostRequest = WritePostRequest.of("", "content");
        assertWritePostRequest(writePostRequest, "writer")

        // then
        .andExpect(status().isBadRequest());
    }

    @Test
    void 게시글_등록시_내용을_입력하지_않을_경우_400() throws Exception {
        // when
        WritePostRequest writePostRequest = WritePostRequest.of("title", "");
        assertWritePostRequest(writePostRequest, "writer")

        // then
        .andExpect(status().isBadRequest());
    }

    private ResultActions assertWritePostRequest(WritePostRequest writePostRequest, String writer) throws Exception {
        return mockMvc.perform(post("/api/v1/post")
                .header("userId", writer)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(writePostRequest)));
    }

    @Test
    void 게시글_단건_조회_200() throws Exception {
        // given
        when(postService.getPost(1L))
        .thenReturn(new PostResource(1L, "title", "content", "writer"));

        // when
        assertGetPost(1L)
        .andExpect(status().isOk())
        .andExpect(jsonPath("id").value(1L))
        .andExpect(jsonPath("title").value("title"))
        .andExpect(jsonPath("content").value("content"))
        .andExpect(jsonPath("writer").value("writer"));
    }

    @Test
    void 게시글_단건_조회시_해당_게시글이_존재하지_않을_경우_404() throws Exception {
        // given
        when(postService.getPost(1L))
        .thenThrow(PostNotFoundException.class);

        // when
        assertGetPost(1L)
        .andExpect(status().isNotFound());
    }

    private ResultActions assertGetPost(long postId) throws Exception {
        return mockMvc.perform(get("/api/v1/post/{postId}", postId));
    }
}
