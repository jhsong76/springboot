package com.example.ddooheeJpa.domain.Match.domain.Dto.patch;

import com.example.ddooheeJpa.domain.Match.domain.Match;
import com.example.ddooheeJpa.domain.Match.domain.userMatchStatus;
import com.example.ddooheeJpa.domain.User.Model.User;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Builder
@Data
public class PatchGetMatchedStatusRes {
    //private User userGetMatched;
    // private User userMatching;

    private Long id;

    //@Enumerated(EnumType.STRING)
    // private userMatchStatus userMatchStatus; // 매칭 상태 [INACTIVE, ACTIVE]

    static public PatchGetMatchedStatusRes toDto(Match match) {
        return PatchGetMatchedStatusRes.builder()
                .id(match.getId())
                .build();
    }
}
