package com.example.ddooheeJpa.match.converter;

import com.example.ddooheeJpa.match.dto.*;
import com.example.ddooheeJpa.user.dto.Dto;
import com.example.ddooheeJpa.user.entity.User;
import com.example.ddooheeJpa.match.entity.Match;
import com.example.ddooheeJpa.match.entity.status;
import com.example.ddooheeJpa.match.entity.userMatchStatus;
import com.example.ddooheeJpa.user.entity.UserInterest;
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

//    public Dto toDto(final User entity) {
//        return Dto.builder()
//                .userId(entity.getUserId())
//                .userNickName(entity.getUserNickName())
//                .userMajorName(entity.getUserMajorName())
//                .userPhoneNum(entity.getUserProfileImg())
//                .build();
//    }
//
//    public GetMatchedUserListDto toResponseDto(final Dto entity, final List<String> userInterests, int userLike){
//        return GetMatchedUserListDto.builder()
//                .userProfilImg(entity.getUserProfileImg())
//                .userNickName(entity.getUserNickName())
//                .userMajorName(entity.getUserMajorName())
//                .userInterests(userInterests)
//                .userLike(userLike)
//                .build();
//    }


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
