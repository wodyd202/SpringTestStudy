package com.ljy.springbootteststudy.services.post.application;

import com.ljy.springbootteststudy.services.post.application.event.RegisteredPostEvent;
import com.ljy.springbootteststudy.services.post.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Transactional(readOnly = true)
    public PostResource getPost(long postId) {
        return postRepository.findById(postId).orElseThrow(PostNotFoundException::new);
    }

    @Transactional
    public Long write(WritePostDto writePostDto, String writer) {
        Post post = postMapper.mapOf(writePostDto, writer);
        Post save = postRepository.save(post);
        applicationEventPublisher.publishEvent(RegisteredPostEvent.idOf(save.getId()));
        return save.getId();
    }
}
