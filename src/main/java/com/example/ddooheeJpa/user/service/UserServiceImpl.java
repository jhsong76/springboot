package com.example.ddooheeJpa.user.service;

import com.example.ddooheeJpa.user.converter.Userconverter;

import com.example.ddooheeJpa.user.dto.UserResponseDto;
import com.example.ddooheeJpa.user.entity.User;
import com.example.ddooheeJpa.user.entity.UserInterest;
import com.example.ddooheeJpa.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final Userconverter converter;


    @Override
    public UserResponseDto findById(final Long userId) {

//        UserResponseDto dto = userRepository.findById(userId)
//                .map(converter::toDto)
//                .orElseThrow(() -> new BaseException(NOT_USER));
//
//        System.out.println(dto);
//        return dto;
       final User entity = userRepository.getById(userId);
       return getUserResponseDto(entity);
//       return userRepository.findById(userId)
//                .map(converter::toDto)
//                .orElseThrow(() -> new BaseException(NOT_USER));

    }

    private UserResponseDto getUserResponseDto(final User entity) {
        return converter.toResponseDto(
                converter.toDto(entity),
                entity.getUserInterests()
                        .stream()
                        .map(UserInterest::getInterest)
                        .collect(Collectors.toList()));
    }
}
