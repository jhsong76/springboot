package com.example.ddooheeJpa.match.converter;

import com.example.ddooheeJpa.match.dto.*;
import com.example.ddooheeJpa.user.entity.User;
import com.example.ddooheeJpa.match.entity.Match;
import com.example.ddooheeJpa.match.entity.status;
import com.example.ddooheeJpa.match.entity.userMatchStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    public MatchResDto ResCreateMatchDto(Match match) {
        return MatchResDto.builder()
                .id(match.getId())
                .build();
    }

    public MatchResDto ResMatchOkDto(Match match) {
        return MatchResDto.builder()
                .id(match.getId())
                .build();
    }

    public MatchAllOkResDto ResMatchAllOkDto(long userGetMatched) {
        return MatchAllOkResDto.builder()
                .userGetMatched(userGetMatched)
                .build();
    }


    public List<GetMatchedUserListDto> GetMatchedListResponseDto(final List<GetMatchedUserListDto> users) {
        return users
                .stream()
                .map(user -> GetMatchedUserListDto.builder()

                        .userInterests(user.getUserInterests())
                .build())
                .collect(Collectors.toList());
    }

    public MatchDto toDto(final Match entity) {
        return MatchDto.builder()
                .UserGetMatched(entity.getId())
                .build();
    }


}
