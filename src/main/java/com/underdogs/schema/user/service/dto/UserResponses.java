package com.underdogs.schema.user.service.dto;

import static java.util.stream.Collectors.*;

import java.util.List;

import com.underdogs.schema.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class UserResponses {

    private List<UserResponse> userResponses;

    public static UserResponses from(List<User> users) {
        return new UserResponses(users.stream()
            .map(UserResponse::from)
            .collect(toList()));
    }
}
