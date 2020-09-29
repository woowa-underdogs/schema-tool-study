package com.underdogs.schema.post.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.underdogs.schema.post.service.PostService;
import com.underdogs.schema.post.service.dto.PostDetailResponse;
import com.underdogs.schema.post.service.dto.PostResponses;
import com.underdogs.schema.post.service.dto.PostSaveRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public ResponseEntity<PostResponses> readAll() {
        PostResponses postResponses = postService.readAll();
        return ResponseEntity.ok(postResponses);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDetailResponse> readOne(@PathVariable Long postId) {
        PostDetailResponse postDetailResponse = postService.readOne(postId);
        return ResponseEntity.ok(postDetailResponse);
    }

    @PostMapping
    public ResponseEntity<Void> save(PostSaveRequest postSaveRequest) {
        Long postId = postService.save(postSaveRequest);
        return ResponseEntity
            .created(URI.create("/api/posts/" + postId))
            .build();
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> delete(@PathVariable Long postId) {
        postService.delete(postId);
        return ResponseEntity
            .noContent()
            .build();
    }
}
