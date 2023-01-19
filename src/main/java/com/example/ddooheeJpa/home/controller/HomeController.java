package com.example.ddooheeJpa.home.controller;

import com.example.ddooheeJpa.config.BaseException;
import com.example.ddooheeJpa.config.BaseResponseStatus;
import com.example.ddooheeJpa.paging.PageRequest;
import com.example.ddooheeJpa.paging.repository.PagingRepository;
import com.example.ddooheeJpa.user.dto.UserStudentDto;
import com.example.ddooheeJpa.user.entity.User;
import com.example.ddooheeJpa.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/home")
public class HomeController {
    private final UserRepository userRepository;
    private final PagingRepository pagingRepository;

    // 재학생 유저 리스트 조회
    @GetMapping("/student")
    public ResponseEntity<List<UserStudentDto>> StudentList(@RequestParam(value = "offset", defaultValue = "0") int offset,
                                                            @RequestParam(value = "limit", defaultValue = "20")int limit) {

            List<User> users = pagingRepository.findAllByGradStatusTrue(offset, limit);
            List<UserStudentDto> result = users.stream()
                    .map(u -> new UserStudentDto(u))
                    .collect(Collectors.toList());
            return ResponseEntity.ok().body(result);

    }
}
