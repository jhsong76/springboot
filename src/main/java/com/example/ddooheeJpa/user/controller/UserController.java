package com.example.ddooheeJpa.user.controller;
import com.example.ddooheeJpa.block.serivce.BlockService;
import com.example.ddooheeJpa.like.dto.LikeDto;
import com.example.ddooheeJpa.like.service.LikeService;
import com.example.ddooheeJpa.report.dto.ReportDto;
import com.example.ddooheeJpa.report.dto.ReportRequestDto;
import com.example.ddooheeJpa.report.service.ReportService;
import com.example.ddooheeJpa.user.dto.UserCancleBlockRequestDto;
import com.example.ddooheeJpa.user.dto.UserDetailDto;
import com.example.ddooheeJpa.user.dto.UserDto;
import com.example.ddooheeJpa.user.dto.UserListDto;

import com.example.ddooheeJpa.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
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

    /**
     * 유저 정보 상세 조회
     * [GET] /users/:id
     *
     * @return ResponseEntity<UserDetailDto>
     */
    @ApiOperation(value = "유저 상제 조회 API", notes = "유저 인덱스 값 입력시 해당하는 유저의 상세 정보 반환")
    @ApiResponses({
            @ApiResponse(code = 200, message = "api 정상 작동"),
            @ApiResponse(code = 400, message = "해당 유저가 존재하지 않습니다.")
    })
    @GetMapping("/{id}")
    public ResponseEntity<UserDetailDto> findUserById(@PathVariable("id") long userId) {

        UserDetailDto response = userService.findById(userId);

        return ResponseEntity.ok().body(response);
    }

    /**
     * 유저 좋아요 등록
     * [POST] /users/:userGiveLikes/:userGetLikes
     *
     * @return ResponseEntity<LikeDto>
     */
    @ApiOperation(value = "유저 좋아요 등록 API", notes = "userGiveLikes -> 좋아요를 한 유저, userGetLikes -> 좋아요를 받은 유저," +
            "userGiveLikes가 userGetLikes를 좋아요 등록")
    @ApiResponses({
            @ApiResponse(code = 200, message = "api 정상 작동"),
            @ApiResponse(code = 400, message = "해당 유저가 존재하지 않습니다. ")
    })
    @PostMapping("/like/{userGiveLikes}/{userGetLikes}")
    public ResponseEntity<LikeDto> userLikes(@PathVariable("userGiveLikes") long userGiveLikes,
                                             @PathVariable("userGetLikes") long userGetLikes) {
        LikeDto response = likeService.userLike(userGiveLikes, userGetLikes);

        return ResponseEntity.ok().body(response);
    }

    /**
     * 유저 신고 등록
     * [POST] /users/report/:userReport/:userGetReported
     *
     * @return ResponseEntity<ReportDto>
     */
    @ApiOperation(value = "유저 신고 등록 API", notes = "userReport -> 신고를 한 유저, userGetReported -> 신고를 받은 유저")
    @ApiResponses({
            @ApiResponse(code = 200, message = "api 정상 작동"),
            @ApiResponse(code = 400, message = "해당 유저가 존재하지 않습니다."),
            @ApiResponse(code = 400, message = "신고 사유를 작성해주세요.")
    })
    @PostMapping("/report/{userReport}/{userGetReported}")
    public ResponseEntity<ReportDto> userReport(@PathVariable("userReport") long userReport,
                                                @PathVariable("userGetReported") long userGetReported,
                                                @RequestBody ReportRequestDto reportRequestDto) {
        ReportDto response = reportService.userReport(userReport, userGetReported, reportRequestDto);
        return ResponseEntity.ok(response);

    }

    /**
     * 차단 리스트 조회
     * [GET] /users/block/:userGiveBlock
     *
     * @return ResponseEntity<List < UserListDto>>
     */
    @ApiOperation(value = "차단 리스트 조회 api", notes = "userGiveBlock이 차단한 유저 리스트 반환")
    @ApiResponses({
            @ApiResponse(code = 200, message = "api 정상 작동"),
            @ApiResponse(code = 400, message = "예상치 못한 예외가 발생했습니다.")
    })
    @GetMapping("/block/{userGiveBlock}")
    public ResponseEntity<List<UserListDto>> GetBlockedList(@PathVariable("userGiveBlock") long userGiveBlock) {
        List<UserListDto> response = blockService.BlockList(userGiveBlock);
        return ResponseEntity.ok().body(response);
    }

    /**
     * 차단 해제
     * [PATCH] /users/block/cancle/:userGiveBlock
     *
     * @return ResponseEntity<List < UserListDto>>
     */
    @PatchMapping("/block")
    public String cancleBlock(@RequestBody UserCancleBlockRequestDto dto) {
        blockService.cancleBlock(dto);
        return "차단 해제가 되었습니다.";
    }

    // 알림 활성화
    @PatchMapping("alaram/{userId}")
    public ResponseEntity<UserDto> activeAlaram(@PathVariable("userId")long userId) {
        UserDto response = userService.activeAlaram(userId);
        return ResponseEntity.ok().body(response);
    }

    // 알림 비활성화
    @PatchMapping("alaram/inactive/{userId}")
    public ResponseEntity<UserDto> inactiveAlaram(@PathVariable("userId")long userId) {
        UserDto response = userService.inactiveAlaram(userId);
        return ResponseEntity.ok().body(response);
    }
}


