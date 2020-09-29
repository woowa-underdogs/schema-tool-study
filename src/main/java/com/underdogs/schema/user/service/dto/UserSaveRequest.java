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
public class UserSaveRequest {

    private String name;
    private Integer age;

    public User toEntity() {
        return User.builder()
            .name(name)
            .age(age)
            .build();
    }
}
