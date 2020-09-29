package com.underdogs.schema.post.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.underdogs.schema.post.domain.Post;
import com.underdogs.schema.post.domain.PostRepository;
import com.underdogs.schema.post.service.dto.PostDetailResponse;
import com.underdogs.schema.post.service.dto.PostResponses;
import com.underdogs.schema.post.service.dto.PostSaveRequest;
import com.underdogs.schema.user.domain.User;
import com.underdogs.schema.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostResponses readAll() {
        List<Post> posts = postRepository.findAll();
        return PostResponses.from(posts);
    }

    public PostDetailResponse readOne(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(IllegalAccessError::new);
        return PostDetailResponse.from(post);
    }

    public Long save(PostSaveRequest postSaveRequest) {
        Post post = postSaveRequest.toEntity();
        User user = userRepository.findById(postSaveRequest.getUserId())
            .orElseThrow(IllegalAccessError::new);
        post.setUser(user);

        Post savedPost = postRepository.save(post);
        return savedPost.getId();
    }

    public void delete(Long postId) {
        postRepository.deleteById(postId);
    }
}
