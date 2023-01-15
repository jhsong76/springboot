package com.example.ddooheeJpa.user.service;

import com.example.ddooheeJpa.user.dto.UserResponseDto;


public interface UserService {
    UserResponseDto findById(final Long userId);
}
