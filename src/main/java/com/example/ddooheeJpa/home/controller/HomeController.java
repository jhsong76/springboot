package com.example.ddooheeJpa.home.controller;

import com.example.ddooheeJpa.filter.converter.UserFilterConverter;
import com.example.ddooheeJpa.filter.dto.UserFilterDto;
import com.example.ddooheeJpa.filter.dto.UserFilterRequestDto;
import com.example.ddooheeJpa.filter.repository.UserGenderForFilterRepository;
import com.example.ddooheeJpa.filter.repository.UserGradeForFilterRepository;
import com.example.ddooheeJpa.filter.repository.UserMajorForFilterRepository;
import com.example.ddooheeJpa.filter.repository.UserMbtiForFilterRepository;
import com.example.ddooheeJpa.filter.service.FilterService;
import com.example.ddooheeJpa.home.service.HomeService;
import com.example.ddooheeJpa.user.dto.UserListDto;
import com.example.ddooheeJpa.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/home")
public class HomeController {

    private final HomeService homeService;
    private final FilterService filterService;
    private final UserFilterConverter filterConverter;
    private final UserRepository userRepository;
    private final UserGenderForFilterRepository userGenderForFilterRepository;
    private final UserGradeForFilterRepository gradeForFilterRepository;
    private final UserMajorForFilterRepository majorForFilterRepository;
    private final UserMbtiForFilterRepository mbtiForFilterRepository;

    // 재학생 유저 리스트 조회
    @GetMapping("/student/true")
    public ResponseEntity<List<UserListDto>> StudentListTrue(@RequestParam(value = "offset", defaultValue = "0") int offset,
                                                             @RequestParam(value = "limit", defaultValue = "20") int limit) {
        List<UserListDto> response = homeService.TrueList(offset, limit);
        return ResponseEntity.ok().body(response);
    }


    // 재학생, 졸업생 유저 리스트 2개 조회
    @GetMapping("/all")
    public ResponseEntity<Map<String, List<UserListDto>>> HomeList(@RequestParam(value = "offset", defaultValue = "0") int offset,
                                                                   @RequestParam(value = "limit", defaultValue = "20") int limit) {
        Map<String, List<UserListDto>> response = new HashMap<>();
        response.put("재학생 유저 리스트", homeService.TrueList(offset, limit));
        response.put("졸업생 유저 리스트", homeService.FalseList(offset, limit));

        return ResponseEntity.ok().body(response);
    }

    // 기존에 지정한 필터 내용 조회
    @GetMapping("/filter/{id}")
    public ResponseEntity<UserFilterDto> selectFilter(@PathVariable("id") long userId) {
        UserFilterDto response = filterService.selectFilter(userId);
        return ResponseEntity.ok().body(response);
    }

    // 필터 저장
    // jwt 토큰에서 유저 인덱스 가져오는걸로 변경하기
    @PostMapping("/filter/save/{id}")
    public ResponseEntity<Map<String, List<UserListDto>>> saveFilter(@PathVariable("id") long userId,
                                      @RequestBody UserFilterRequestDto dto) {

        Map<String, List<UserListDto>> response = new HashMap<>();
        response.put("재학생 유저 리스트", filterService.TrueList(userId, dto));
        response.put("졸업생 유저 리스트", filterService.FalseList(userId));

        return ResponseEntity.ok().body(response);
    }

    // 닉네임 검색 기능
    @GetMapping("/search")
    public ResponseEntity<List<UserListDto>> SearchByNickName(@RequestParam(value ="nickName")String nickName) {
        List<UserListDto> response = homeService.search(nickName);
        return ResponseEntity.ok().body(response);
    }
}
