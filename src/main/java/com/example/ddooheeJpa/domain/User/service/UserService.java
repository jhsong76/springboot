package com.example.ddooheeJpa.domain.User.service;

import com.example.ddooheeJpa.domain.User.dto.UserResponseDto;
import org.springframework.stereotype.Service;


public interface UserService {
    UserResponseDto findById(final Long userId);
}
