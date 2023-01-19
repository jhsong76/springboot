package com.example.ddooheeJpa.match.controller;


import com.example.ddooheeJpa.match.dto.*;
import com.example.ddooheeJpa.match.service.MatchService;
import com.example.ddooheeJpa.user.entity.User;
import com.example.ddooheeJpa.user.entity.UserInterest;
import com.example.ddooheeJpa.user.entity.UserPersonality;
import com.example.ddooheeJpa.user.repository.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/match")
public class MatchController {
    private final MatchService matchService;

    private final UserRepository userRepository;
    // 매칭 시도
    @PostMapping("/{userMatching}/{userGetMatched}")
    public ResponseEntity<MatchResDto> matching(@PathVariable("userMatching") long userMatching, @PathVariable("userGetMatched") long userGetMatched) {
        final MatchResDto response = matchService.matching(userMatching, userGetMatched);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 매칭 수락
    @PatchMapping("/{id}")
    public ResponseEntity<MatchResDto> matchOk(@PathVariable("id")Long id) {

        final MatchResDto response = matchService.matchOk(id);
        return ResponseEntity.ok().body(response);

    }

    // 매칭 거절
    @PostMapping("/{id}")
    public ResponseEntity<MatchResDto> matchNo(@PathVariable("id")Long id) {
        final MatchResDto response = matchService.matchNo(id);
        return ResponseEntity.ok().body(response);
    }

    // 모든 매칭 수락
    @PatchMapping("/{userGetMatched}/all")
    public ResponseEntity<MatchAllOkResDto> matckAllOk(@PathVariable("userGetMatched")Long userGetMatched) {
        final MatchAllOkResDto response = matchService.matchAllOk(userGetMatched);
        return ResponseEntity.ok().body(response);
    }

    // 내가 매칭 시도한 내역 삭제
    @PostMapping("/{id}/block")
    public ResponseEntity<MatchResDto> matchBlock(@PathVariable("id")Long id) {
        final MatchResDto response = matchService.matchDelete(id);
        return ResponseEntity.ok().body(response);
    }

    // 나에게 매칭 시도한 유저 전체 조회
    @GetMapping("/AllUser")
    public ResponseEntity<List<UserGetMatchList>> GetMatchedList() {
        List<User> users = userRepository.findAll();
        List<UserGetMatchList> result = users.stream()
                .map(u -> new UserGetMatchList(u))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(result);
    }

    @Data
    static class UserGetMatchList{
        private Long userId;
        private String userNickName;
        private String userMajorName;
        private String userStudentNum;
        private int userGender;
        private String userInfo;
        private String userprofileImg;
        private String userMbti;

        private List<UserInterestDto> userInterests;
        private List<UserPersonalityDto> userPesonalitys;

        public UserGetMatchList(User user) {
            userId = user.getUserId();
            userNickName = user.getUserNickName();
            userMajorName = user.getUserMajorName();
            userStudentNum = user.getUserStudentNum();
            userGender = user.getUserGender();
            userInfo = user.getUserInfo();
            userprofileImg = user.getUserProfileImg();
            userMbti = user.getUserMbti();
            userInterests = user.getUserInterests().stream()
                    .map(userInterest -> new UserInterestDto(userInterest))
                    .collect(Collectors.toList());
            userPesonalitys = user.getUserPesonalitys().stream()
                    .map(userPersonality -> new UserPersonalityDto(userPersonality))
                    .collect(Collectors.toList());
        }

    }

    @Data
    static class UserInterestDto{
        private String Interest;

        public UserInterestDto(UserInterest userInterest) {
            Interest = userInterest.getInterest();
        }
    }

    @Data
    static class UserPersonalityDto{
        private String personality;

        public UserPersonalityDto(UserPersonality userPersonality) {
            personality = userPersonality.getPersonality();
        }
    }
}
