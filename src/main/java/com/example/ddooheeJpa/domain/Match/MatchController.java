package com.example.ddooheeJpa.domain.Match;

import com.example.ddooheeJpa.config.BaseResponse;
import com.example.ddooheeJpa.domain.Match.domain.Dto.patch.PatchGetMatchedStatusReq;
import com.example.ddooheeJpa.domain.Match.domain.Dto.patch.PatchGetMatchedStatusRes;
import com.example.ddooheeJpa.domain.Match.domain.Match;
import com.example.ddooheeJpa.domain.Match.domain.MatchDTO;
import com.example.ddooheeJpa.domain.User.Model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
@RequestMapping("/match")
public class MatchController {
    private final MatchService matchService;

    // 매칭 시도
    @PostMapping("")
    public ResponseEntity<Match> postMatch(@RequestBody MatchDTO dto) {
        Match match = matchService.match(dto);

        return new ResponseEntity<>(match, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    @ResponseBody
    public BaseResponse<PatchGetMatchedStatusRes> updateGetMatchedStatus(@PathVariable("id") Long id,
          @RequestBody PatchGetMatchedStatusReq dto) {
        Match match = matchService.updateGetMatchedStatus(id, dto);

        PatchGetMatchedStatusRes patchGetMatchedStatusRes =
                PatchGetMatchedStatusRes.toDto(match);
        return new BaseResponse<>(patchGetMatchedStatusRes);
    }

    @PatchMapping("/{id}/block")
    @ResponseBody
    public BaseResponse<PatchGetMatchedStatusRes> updateGetMatchedStatusBlock(@PathVariable("id") Long id,
            @RequestBody PatchGetMatchedStatusReq dto) {
        Match match = matchService.updateGetMatchedStatus(id, dto);

        PatchGetMatchedStatusRes patchGetMatchedStatusRes =
                PatchGetMatchedStatusRes.toDto(match);
        return new BaseResponse<>(patchGetMatchedStatusRes);
    }
}
