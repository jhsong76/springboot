package com.example.ddooheeJpa.match.controller;

import com.example.ddooheeJpa.block.dto.BlockDto;
import com.example.ddooheeJpa.block.serivce.BlockService;
import com.example.ddooheeJpa.match.dto.MatchDto;
import com.example.ddooheeJpa.match.dto.MatchListDto;
import com.example.ddooheeJpa.match.service.MatchService;
import com.example.ddooheeJpa.user.dto.UserListDto;
import com.example.ddooheeJpa.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/match")
public class MatchController {

    private final MatchService matchService;
    private final UserRepository userRepository;
    private final BlockService blockService;


    // 매칭 시도
    @PostMapping("/{userMatching}/{userGetMatched}")
    public ResponseEntity<MatchDto> matching(@PathVariable("userMatching") long userMatching, @PathVariable("userGetMatched") long userGetMatched) {
        MatchDto response = matchService.matching(userMatching, userGetMatched);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 매칭 수락
    @PatchMapping("/{id}")
    public ResponseEntity<MatchDto> matchOk(@PathVariable("id") long id) {
        MatchDto response = matchService.matchOk(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 매칭 거절
    @PostMapping("/{id}")
    public ResponseEntity<BlockDto> matchNo(@PathVariable("id") long id) {
        BlockDto response = matchService.matchNo(id);
        return ResponseEntity.ok().body(response);
    }

    // 모든 매칭 수락
    @PatchMapping("/{userGetMatched}/all")
    public ResponseEntity<MatchListDto> matckAllOk(@PathVariable("userGetMatched") long userGetMatched) {
        MatchListDto response = matchService.matchAllOk(userGetMatched);
        return ResponseEntity.ok().body(response);
    }

    // 내가 매칭 시도한 내역 삭제
    @PostMapping("/{id}/block")
    public ResponseEntity<BlockDto> matchBlock(@PathVariable("id") Long id) {
        BlockDto response = matchService.matchDelete(id);
        return ResponseEntity.ok().body(response);
    }

    // 나에게 매칭 시도한 유저 전체 조회
    @GetMapping("/{userGetMatched}/all")
    public ResponseEntity<List<UserListDto>> GetMatchedList(@PathVariable("userGetMatched") long userGetMatched) {
        List<UserListDto> response = matchService.GetMatchedList(userGetMatched);
        return ResponseEntity.ok().body(response);

    }

    // 내가 매칭 시도한 유저 전체 조회
    @GetMapping("{userMatching}/matching")
    public ResponseEntity<List<UserListDto>> MatchingList(@PathVariable("userMatching") long userMatching) {

        List<UserListDto> response = matchService.MatchingList(userMatching);
        return ResponseEntity.ok().body(response);

    }

    // 유저 차단
    @PostMapping("{userGiveBlock}/{userGetBlocked}/block")
    public ResponseEntity<BlockDto> UserBlock(@PathVariable("userGiveBlock") long userGiveBlock, @PathVariable("userGetBlocked") long userGetBlocked) {
        BlockDto response = blockService.userBlock(userGiveBlock, userGetBlocked);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 매칭 내역 리스트 조회 (매칭 홈)
    @GetMapping("{id}")
    public ResponseEntity<Map<String, List<UserListDto>>> getDoubleList(@PathVariable("id")long userId) {
        Map<String, List<UserListDto>> response = new HashMap<>();
        response.put("나에게 연결을 시도한 회원", matchService.homeGetMatchedList(userId));
        response.put("내가 연결을 시도한 회원", matchService.homeMatchingList(userId));

        return ResponseEntity.ok().body(response);
    }
}
