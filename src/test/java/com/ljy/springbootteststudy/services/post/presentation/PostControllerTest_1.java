package com.ljy.springbootteststudy.services.post.presentation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ljy.springbootteststudy.services.post.StubPostRepository;
import com.ljy.springbootteststudy.services.post.application.PostMapper;
import com.ljy.springbootteststudy.services.post.application.PostService;
import com.ljy.springbootteststudy.web.post.PostController;
import com.ljy.springbootteststudy.web.post.WritePostRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

class PostControllerTest_1 {
    private MockMvc mockMvc;
    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp(){
        PostService postService = new PostService(new StubPostRepository(), new PostMapper());
        PostController postController = new PostController(postService);
        mockMvc = standaloneSetup(postController)
                .build();
    }

    @Test
    void 게시글_등록() throws Exception {
        // given
        WritePostRequest writePostRequest = WritePostRequest.of("title", "content");

        // when
        mockMvc.perform(post("/api/v1/post")
                        .header("userId","user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(writePostRequest)))

        // then
        .andExpect(status().isCreated())
        .andDo(print());
    }
}
