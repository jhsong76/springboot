package com.example.ddooheeJpa.user.controller;

import com.example.ddooheeJpa.block.serivce.BlockService;
import com.example.ddooheeJpa.like.dto.LikeDto;
import com.example.ddooheeJpa.like.service.LikeService;
import com.example.ddooheeJpa.report.dto.ReportDto;
import com.example.ddooheeJpa.report.dto.ReportRequestDto;
import com.example.ddooheeJpa.report.service.ReportService;
import com.example.ddooheeJpa.user.dto.UserDetailDto;
import com.example.ddooheeJpa.user.dto.UserListDto;
import com.example.ddooheeJpa.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final LikeService likeService;
    private final ReportService reportService;
    private final BlockService blockService;

    // 유저 정보 상세 조회
    @GetMapping("/{id}")
    public ResponseEntity<UserDetailDto> findUserById(@PathVariable("id") long userId) {

        UserDetailDto response = userService.findById(userId);

        return ResponseEntity.ok().body(response);
    }

    // 유저 좋아요 등록
    @PostMapping("/like/{userGiveLikes}/{userGetLikes}")
    public ResponseEntity<LikeDto> userLikes(@PathVariable("userGiveLikes") long userGiveLikes,
                                             @PathVariable("userGetLikes") long userGetLikes) {
        LikeDto response = likeService.userLike(userGiveLikes, userGetLikes);

        return ResponseEntity.ok().body(response);
    }

    // 유저 신고 등록
    @PostMapping("/report/{userReport}/{userGetReported}")
    public ResponseEntity<ReportDto> userReport(@PathVariable("userReport") long userReport,
                                                @PathVariable("userGetReported") long userGetReported,
                                                @RequestBody ReportRequestDto reportRequestDto) {
        ReportDto response = reportService.userReport(userReport, userGetReported, reportRequestDto);
        return ResponseEntity.ok(response);

    }

    // 차단 리스트 조회
    @GetMapping("/block/{userGiveBlock}")
    public ResponseEntity<List<UserListDto>> GetBlockedList(@PathVariable("userGiveBlock") long userGiveBlock) {
        List<UserListDto> response = blockService.BlockList(userGiveBlock);
        return ResponseEntity.ok().body(response);
    }

}
