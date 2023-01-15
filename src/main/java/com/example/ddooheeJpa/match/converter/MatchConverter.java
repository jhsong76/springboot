package com.example.ddooheeJpa.match.converter;

import com.example.ddooheeJpa.domain.User.entity.User;
import com.example.ddooheeJpa.match.dto.MatchAllOkResDto;
import com.example.ddooheeJpa.match.dto.MatchOkResDto;
import com.example.ddooheeJpa.match.dto.MatchingCreateResDto;
import com.example.ddooheeJpa.match.entity.Match;
import com.example.ddooheeJpa.match.entity.status;
import com.example.ddooheeJpa.match.entity.userMatchStatus;
import org.springframework.stereotype.Component;

@Component
public class MatchConverter {
    public Match ReqCreateMatchDto(final User userMatching, final User userGetMatched) {
        return Match.builder()
                .userMatching(userMatching)
                .userGetMatched(userGetMatched)
                .userMatchStatus(userMatchStatus.INACTIVE)
                .status(status.ACTIVE)
                .build();
    }

    public MatchingCreateResDto ResCreateMatchDto(Match match) {
        return MatchingCreateResDto.builder()
                .id(match.getId())
                .build();
    }

    public MatchOkResDto ResMatchOkDto(Match match) {
        return MatchOkResDto.builder()
                .id(match.getId())
                .build();
    }

    public MatchAllOkResDto ResMatchAllOkDto(long userGetMatched) {
        return MatchAllOkResDto.builder()
                .userGetMatched(userGetMatched)
                .build();
    }
}
