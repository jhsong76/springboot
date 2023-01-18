package com.example.ddooheeJpa.user.controller;

import com.example.ddooheeJpa.like.dto.ReqCreateUserLikeDto;
import com.example.ddooheeJpa.user.dto.UserResponseDto;
import com.example.ddooheeJpa.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findUserById(@PathVariable("id")final Long userId) {

        UserResponseDto response = userService.findById(userId);

        return ResponseEntity.ok().body(response);
    }

    // 유저 좋아요 등록
    @PostMapping("/{userGiveLikes}/{userGetLikes}")
    public ResponseEntity<ReqCreateUserLikeDto> userLikes(@PathVariable("userGiveLikes")final Long userGiveLikes,
                                                          @PathVariable("userGetLikes")final Long userGetLikes) {
        ReqCreateUserLikeDto response = userService.userLikes(userGetLikes, userGiveLikes);

        return ResponseEntity.ok().body(response);
    }
}
