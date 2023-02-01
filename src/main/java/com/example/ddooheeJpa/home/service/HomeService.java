package com.example.ddooheeJpa.home.service;

import com.example.ddooheeJpa.home.repository.PagingRepository;
import com.example.ddooheeJpa.user.dto.UserDetailDto;
import com.example.ddooheeJpa.user.dto.UserListDto;
import com.example.ddooheeJpa.user.entity.User;
import com.example.ddooheeJpa.user.mapper.UserMapper;
import com.example.ddooheeJpa.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class HomeService {

    private final PagingRepository pagingRepository;
    private final UserRepository userRepository;
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

    // 닉네임 검색 기능
    @Transactional
    public List<UserListDto> search(String nickName){
        List<User> userList = userRepository.findByuserNickNameContaining(nickName);
        List<UserListDto> dto = UserMapper.INSTANCE.entityToDtoList(userList);

        return dto;
    }

    /* Paging */
    @Transactional
    public List<UserListDto> pageList(Pageable pageable) {
        int count = 10;
       // List<User> users = userRepository.findAll(PageRequest.of(0,count)).toList();//(pageable);
        List<User> users = userRepository.findAll(pageable).getContent();
        List<UserListDto> dto = UserMapper.INSTANCE.entityToDtoList(users);

        return dto;
    }
}
