package com.example.ddooheeJpa.match.controller;


import com.example.ddooheeJpa.domain.User.entity.User;
import com.example.ddooheeJpa.match.dto.MatchAllOkResDto;
import com.example.ddooheeJpa.match.dto.MatchNoResDto;
import com.example.ddooheeJpa.match.dto.MatchOkResDto;
import com.example.ddooheeJpa.match.dto.MatchingCreateResDto;
import com.example.ddooheeJpa.match.service.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/match")
public class MatchController {
    private final MatchService matchService;

    // 매칭 시도
    @PostMapping("/{userMatching}/{userGetMatched}")
    public ResponseEntity<MatchingCreateResDto> matching(@PathVariable("userMatching") long userMatching, @PathVariable("userGetMatched") long userGetMatched) {
        final MatchingCreateResDto response = matchService.matching(userMatching, userGetMatched);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 매칭 수락
    @PatchMapping("/{id}")
    public ResponseEntity<MatchOkResDto> matchOk(@PathVariable("id")Long id) {

        final MatchOkResDto response = matchService.matchOk(id);
        return ResponseEntity.ok().body(response);

    }

    // 매칭 거절
    @PostMapping("/{id}")
    public ResponseEntity<MatchNoResDto> matchNo(@PathVariable("id")Long id) {
        final MatchNoResDto response = matchService.matchNo(id);
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
    public ResponseEntity<MatchNoResDto> matchBlock(@PathVariable("id")Long id) {
        final MatchNoResDto response = matchService.matchDelete(id);
        return ResponseEntity.ok().body(response);
    }
}