package com.ljy.springbootteststudy.web.post;

import com.ljy.springbootteststudy.services.post.application.PostService;
import com.ljy.springbootteststudy.services.post.application.WritePostDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/post")
public class PostController {
    private final PostService postService;

    @PostMapping
    public ResponseEntity<Long> write(@RequestHeader("userId") String userId,
                                      @Valid @RequestBody WritePostRequest writePostRequest){
        WritePostDto writePostDto = writePostRequest.toDto();
        Long postId = postService.write(writePostDto, userId);
        return ResponseEntity.created(URI.create("/api/v1/post/" + postId)).build();
    }
}
