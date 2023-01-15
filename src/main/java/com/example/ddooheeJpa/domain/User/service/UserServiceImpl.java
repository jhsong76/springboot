package com.example.ddooheeJpa.domain.User.service;

import com.example.ddooheeJpa.config.BaseException;

import com.example.ddooheeJpa.domain.User.converter.Userconverter;
import com.example.ddooheeJpa.domain.User.dto.UserResponseDto;
import com.example.ddooheeJpa.domain.User.entity.User;
import com.example.ddooheeJpa.domain.User.entity.UserInterest;
import com.example.ddooheeJpa.domain.User.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

import static com.example.ddooheeJpa.config.BaseResponseStatus.NOT_USER;

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
