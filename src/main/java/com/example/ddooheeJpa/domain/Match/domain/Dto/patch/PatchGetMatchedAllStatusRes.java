package com.example.ddooheeJpa.domain.Match.domain.Dto.patch;

import com.example.ddooheeJpa.domain.Match.domain.Match;
import com.example.ddooheeJpa.domain.User.entity.User;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PatchGetMatchedAllStatusRes {

    private User userGetMatched;

    static public PatchGetMatchedAllStatusRes toDto(Match match) {
        return PatchGetMatchedAllStatusRes.builder()
                .userGetMatched(match.getUserGetMatched())
                .build();
    }
}
