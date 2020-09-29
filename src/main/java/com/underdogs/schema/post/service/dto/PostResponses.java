package com.underdogs.schema.post.service.dto;

import static java.util.stream.Collectors.*;

import java.util.List;

import com.underdogs.schema.post.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class PostResponses {

    private List<PostResponse> postResponses;

    public static PostResponses from(List<Post> posts) {
        List<PostResponse> postResponses = posts.stream()
            .map(PostResponse::from)
            .collect(toList());
        return new PostResponses(postResponses);
    }
}
