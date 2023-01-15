package com.example.ddooheeJpa.domain.User.controller;

import com.example.ddooheeJpa.domain.User.dto.UserResponseDto;
import com.example.ddooheeJpa.domain.User.entity.User;
import com.example.ddooheeJpa.domain.User.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findUserById(@PathVariable("id")final Long userId) {

//        UserResponseDto dto = userService.findById(userId);
//        return new ResponseEntity<>(dto, HttpStatus.OK);
        return ResponseEntity.ok(userService.findById(userId));
    }
}
