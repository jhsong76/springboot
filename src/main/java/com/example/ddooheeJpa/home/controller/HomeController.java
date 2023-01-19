package com.example.ddooheeJpa.home.controller;

import com.example.ddooheeJpa.user.dto.UserStudentDto;
import com.example.ddooheeJpa.user.entity.User;
import com.example.ddooheeJpa.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/home")
public class HomeController {
    private final UserRepository userRepository;

    // 재학생 유저 리스트 조회
    @GetMapping("/student")
    public ResponseEntity<List<UserStudentDto>> StudentList() {
        List<User> users = userRepository.findAllByGradStatusTrue();
        List<UserStudentDto> result = users.stream()
                .map(u -> new UserStudentDto(u))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(result);
    }
}
