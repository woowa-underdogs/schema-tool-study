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
public class PostSaveRequest {

    private Long userId;
    private String title;
    private String content;

    public Post toEntity() {
        return Post.builder()
            .title(title)
            .content(content)
            .build();
    }
}
