package com.example.ddooheeJpa.domain.Match;

import com.example.ddooheeJpa.config.BaseResponse;
import com.example.ddooheeJpa.domain.Match.domain.Dto.get.GetMatchUserRes;
import com.example.ddooheeJpa.domain.Match.domain.Dto.patch.PatchGetMatchedStatusReq;
import com.example.ddooheeJpa.domain.Match.domain.Dto.patch.PatchGetMatchedStatusRes;
import com.example.ddooheeJpa.domain.Match.domain.Match;
import com.example.ddooheeJpa.domain.Match.domain.MatchDTO;
import com.example.ddooheeJpa.domain.User.service.UserService;
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

    //private final UserService userService;
    // 매칭 시도
//    @PostMapping("")
//    public ResponseEntity<Match> postMatch(@RequestBody MatchDTO dto) {
//        Match match = matchService.match(dto);
//
//        return new ResponseEntity<>(match, HttpStatus.OK);
//    }



    // 매칭 허용
    @PatchMapping("/{id}")
    @ResponseBody
    public BaseResponse<PatchGetMatchedStatusRes> updateGetMatchedStatus(@PathVariable("id") Long id,
                                                                         @RequestBody PatchGetMatchedStatusReq dto) {
        Match match = matchService.updateGetMatchedStatus(id , dto);

        PatchGetMatchedStatusRes patchGetMatchedStatusRes =
                PatchGetMatchedStatusRes.toDto(match);
        return new BaseResponse<>(patchGetMatchedStatusRes);
    }



     // 매칭 거절
    @PatchMapping("/{id}/block")
    @ResponseBody
    public BaseResponse<PatchGetMatchedStatusRes> updateGetMatchedStatusBlock(@PathVariable("id") Long id,
                                                                              @RequestBody PatchGetMatchedStatusReq dto) {
        Match match = matchService.updateGetMatchedStatus(id, dto);

        PatchGetMatchedStatusRes patchGetMatchedStatusRes =
                PatchGetMatchedStatusRes.toDto(match);
        return new BaseResponse<>(patchGetMatchedStatusRes);
    }

    // 모든 연결 수락
    /*@PatchMapping("/all/{userIdx}")
    @ResponseBody
    public BaseResponse<UserGetMatchedMapping> updateGetMatchedAllStatus(@PathVariable("userIdx")long userIdx
                                                                            ) {
        //Match match = matchService.updateGetMatchedAllStatus(userGetMatched);

        UserGetMatchedMapping UserGetMatchedMapping = matchService.updateGetMatchedAllStatus(userGetMatched);

        return new BaseResponse<>(UserGetMatchedMapping);
    }*/

    // 매칭 내역 리스트 조회
    @GetMapping("/{user_id}")
    @ResponseBody BaseResponse<Map<String, List<GetMatchUserRes>>> getUserByUser(@PathVariable long user_id){

        Map<String, List<GetMatchUserRes>> getMatchUserRes = new HashMap<>();

        List<GetMatchUserRes> GetMatchedResponse = matchService.getMatchedUser(user_id);
        List<GetMatchUserRes> GetMatchingResponse = matchService.getMatchingUser(user_id);
        getMatchUserRes.put("나에게 연결을 시도한 회원 ", GetMatchedResponse);
        getMatchUserRes.put("내가 연결을 시도한 회원 정보", GetMatchingResponse);

        return new BaseResponse<>(getMatchUserRes);
    }



}