package com.underdogs.schema.post.service.dto;

import com.underdogs.schema.post.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class PostResponse {
    private Long id;
    private String title;
    private Long userId;
    private String userName;

    public static PostResponse from(Post post) {
        return PostResponse.builder()
            .id(post.getId())
            .title(post.getTitle())
            .userId(post.getUser().getId())
            .userName(post.getUser().getName())
            .build();
    }
}
