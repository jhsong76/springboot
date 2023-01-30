package com.example.ddooheeJpa.user.service;

import com.example.ddooheeJpa.common.exception.LInkyBussinessException;
import com.example.ddooheeJpa.user.dto.UserDetailDto;
import com.example.ddooheeJpa.user.entity.User;
import com.example.ddooheeJpa.user.mapper.UserMapper;
import com.example.ddooheeJpa.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    // 유저 상세 정보 조회
    public UserDetailDto findById(long userId) {

        User users = userRepository.findById(userId)
                .orElseThrow(() -> new LInkyBussinessException("해당 유저가 존재하지 않습니다. ", HttpStatus.BAD_REQUEST));

        users.UserLikeCount();

        UserDetailDto dto = UserMapper.INSTANCE.UserdetaildtoToEntity(users);
        return dto;
    }


}
