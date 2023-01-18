package com.example.ddooheeJpa.user.service;


import com.example.ddooheeJpa.like.dto.ReqCreateUserLikeDto;
import com.example.ddooheeJpa.user.dto.UserResponseDto;

public interface UserService {
    UserResponseDto findById(final Long userId);
    ReqCreateUserLikeDto userLikes(final long userGetLikes,final long userGive);
}
