package com.underdogs.schema.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.underdogs.schema.user.domain.User;
import com.underdogs.schema.user.domain.UserRepository;
import com.underdogs.schema.user.service.dto.UserDetailResponse;
import com.underdogs.schema.user.service.dto.UserResponses;
import com.underdogs.schema.user.service.dto.UserSaveRequest;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponses readAll() {
        List<User> users = userRepository.findAll();
        return UserResponses.from(users);
    }

    public UserDetailResponse readOne(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(IllegalAccessError::new);
        return UserDetailResponse.from(user);
    }

    public Long save(UserSaveRequest userSaveRequest) {
        User user = userSaveRequest.toEntity();
        User savedUser = userRepository.save(user);
        return savedUser.getId();
    }

    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }
}
