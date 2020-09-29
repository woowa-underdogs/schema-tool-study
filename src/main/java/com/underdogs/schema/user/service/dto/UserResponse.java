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
public class UserResponse {

    private Long id;
    private String name;
    private Integer age;

    public static UserResponse from(User user) {
        return UserResponse.builder()
            .id(user.getId())
            .name(user.getName())
            .age(user.getAge())
            .build();
    }
}
