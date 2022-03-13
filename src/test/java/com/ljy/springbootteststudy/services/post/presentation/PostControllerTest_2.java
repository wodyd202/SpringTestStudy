package com.ljy.springbootteststudy.services.post.presentation;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
}
