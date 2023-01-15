package com.example.ddooheeJpa.domain.User.converter;

import com.example.ddooheeJpa.domain.User.dto.Dto;
import com.example.ddooheeJpa.domain.User.dto.UserResponseDto;
import com.example.ddooheeJpa.domain.User.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Userconverter {
    public Dto toDto(final User entity) {
        return Dto.builder()
                .userId(entity.getUserId())
                .userPhoneNum(entity.getUserPhoneNum())
                .userNickName(entity.getUserNickName())
                .userMajorName(entity.getUserMajorName())
                .userStudentNum(entity.getUserStudentNum())
                .userGender(entity.getUserGender())
                .userMbti(entity.getUserMbti())
                .userInfo(entity.getUserInfo())
                .userProfileImg(entity.getUserProfileImg())
                .build();
    }

    public UserResponseDto toResponseDto(final Dto entity, final List<String> userInterests) {
        return UserResponseDto.builder()
                .userId(entity.getUserId())
                .userPhoneNum(entity.getUserPhoneNum())
                .userNickName(entity.getUserNickName())
                .userMajorName(entity.getUserMajorName())
                .userStudentNum(entity.getUserStudentNum())
                .userGender(entity.getUserGender())
                .userMbti(entity.getUserMbti())
                .userInfo(entity.getUserInfo())
                .userProfileImg(entity.getUserProfileImg())
                .userInterests(userInterests)
                .build();
    }
}
