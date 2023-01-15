package com.example.ddooheeJpa.domain.Match.domain.Dto.patch;

import com.example.ddooheeJpa.domain.Match.domain.Match;
import com.example.ddooheeJpa.domain.User.entity.User;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PatchGetMatchedStatusRes {
    //private User userGetMatched;
    // private User userMatching;

    private User userGetMatched;

    //@Enumerated(EnumType.STRING)
    // private userMatchStatus userMatchStatus; // 매칭 상태 [INACTIVE, ACTIVE]

    static public PatchGetMatchedStatusRes toDto(Match match) {
        return PatchGetMatchedStatusRes.builder()
                .userGetMatched(match.getUserGetMatched())
                .build();
    }
}
