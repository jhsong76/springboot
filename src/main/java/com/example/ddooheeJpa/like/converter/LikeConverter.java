package com.example.ddooheeJpa.like.converter;

import com.example.ddooheeJpa.like.dto.LikeDto;
import com.example.ddooheeJpa.like.dto.ReqCreateUserLikeDto;
import com.example.ddooheeJpa.user.entity.User;
import com.example.ddooheeJpa.user.entity.UserLikes;
import org.springframework.stereotype.Component;

@Component
public class LikeConverter {
    public LikeDto toDto(final UserLikes entity) {
        return LikeDto.builder()
                .userGetMatched(entity.getId())
                .build();
    }

    public UserLikes ReqCreateUserLikeDto(final User give, final User get) {
        return UserLikes.builder()
                .userGiveLikes(give)
                .userGetLikes(get)
                .build();
    }

    public ReqCreateUserLikeDto ResCreateUserLikeDto(UserLikes userLikes) {
        return ReqCreateUserLikeDto.builder()
                .id(userLikes.getId())
                .build();
    }
}
