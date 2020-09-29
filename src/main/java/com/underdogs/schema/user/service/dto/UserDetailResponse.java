package com.underdogs.schema.user.service.dto;

import com.underdogs.schema.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class UserDetailResponse {

    private Long id;
    private String name;
    private Integer age;

    public static UserDetailResponse from(User user) {
        return UserDetailResponse.builder()
            .id(user.getId())
            .name(user.getName())
            .age(user.getAge())
            .build();
    }
}
