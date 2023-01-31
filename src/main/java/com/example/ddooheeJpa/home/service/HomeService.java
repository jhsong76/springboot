package com.example.ddooheeJpa.home.service;

import com.example.ddooheeJpa.home.repository.PagingRepository;
import com.example.ddooheeJpa.user.dto.UserListDto;
import com.example.ddooheeJpa.user.entity.User;
import com.example.ddooheeJpa.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class HomeService {

    private final PagingRepository pagingRepository;

    // 재학생 유저 리스트 조회
    public List<UserListDto> TrueList(int offset, int limit) {
        List<User> users = pagingRepository.findAllByGradStatusTrue(offset, limit);
        List<UserListDto> dto = UserMapper.INSTANCE.entityToDtoList(users);
        return dto;
    }

    // 졸업생 유저 리스트 조회
    public List<UserListDto> FalseList(int offset, int limit) {
        List<User> users = pagingRepository.findAllByGradStatusFalse(offset, limit);
        List<UserListDto> dto = UserMapper.INSTANCE.entityToDtoList(users);

        return dto;
    }
}