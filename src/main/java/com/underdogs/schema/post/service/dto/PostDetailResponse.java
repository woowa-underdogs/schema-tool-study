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
public class PostDetailResponse {

    private Long id;
    private Long userId;
    private String userName;
    private String title;
    private String content;

    public static PostDetailResponse from(Post post) {
        return PostDetailResponse.builder()
            .id(post.getId())
            .userId(post.getUser().getId())
            .userName(post.getUser().getName())
            .title(post.getTitle())
            .content(post.getContent())
            .build();
    }
}
