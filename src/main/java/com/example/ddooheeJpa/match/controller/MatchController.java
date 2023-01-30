package com.example.ddooheeJpa.match.controller;

import com.example.ddooheeJpa.block.dto.BlockDto;
import com.example.ddooheeJpa.match.dto.MatchDto;
import com.example.ddooheeJpa.match.dto.MatchListDto;
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
}
