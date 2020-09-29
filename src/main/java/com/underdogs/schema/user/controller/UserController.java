package com.underdogs.schema.user.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.underdogs.schema.user.service.UserService;
import com.underdogs.schema.user.service.dto.UserDetailResponse;
import com.underdogs.schema.user.service.dto.UserResponses;
import com.underdogs.schema.user.service.dto.UserSaveRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<UserResponses> readAll() {
        UserResponses userResponses = userService.readAll();
        return ResponseEntity.ok(userResponses);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDetailResponse> readOne(@PathVariable Long userId) {
        UserDetailResponse userDetailResponse = userService.readOne(userId);
        return ResponseEntity.ok(userDetailResponse);
    }

    @PostMapping
    public ResponseEntity<Void> save(UserSaveRequest userSaveRequest) {
        Long userId = userService.save(userSaveRequest);
        return ResponseEntity
            .created(URI.create("/api/users/" + userId))
            .build();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> delete(@PathVariable Long userId) {
        userService.delete(userId);
        return ResponseEntity
            .noContent()
            .build();
    }
}
