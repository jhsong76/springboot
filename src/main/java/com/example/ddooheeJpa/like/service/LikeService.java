package com.example.ddooheeJpa.like.service;

import com.example.ddooheeJpa.common.exception.LInkyBussinessException;
import com.example.ddooheeJpa.like.converter.LikeConverter;
import com.example.ddooheeJpa.like.dto.LikeDto;
import com.example.ddooheeJpa.like.entity.UserLikes;
import com.example.ddooheeJpa.like.mapper.LikeMapper;
import com.example.ddooheeJpa.like.repository.LikeRepository;
import com.example.ddooheeJpa.user.entity.User;
import com.example.ddooheeJpa.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LikeService {
    private final LikeRepository likeRepository;
    private final LikeConverter likeConverter;
    private final UserRepository userRepository;

    // 유저 좋아요 등록
    @Transactional
    public LikeDto userLike(Long userGiveLikes, Long userGetLikes) {
        User Give = userRepository.findById(userGiveLikes)
                .orElseThrow(() -> new LInkyBussinessException("해당 유저가 존재하지 않습니다. ", HttpStatus.BAD_REQUEST));
        User Get = userRepository.findById(userGetLikes)
                .orElseThrow(() -> new LInkyBussinessException("해당 유저가 존재하지 않습니다.", HttpStatus.BAD_REQUEST));

        User users = userRepository.getReferenceById(userGetLikes);
        users.UserLikeCount();

        UserLikes entity = likeRepository.save(likeConverter.UserLike(Give, Get));
        LikeDto dto = LikeMapper.INSTANCE.entityToDto(entity);

        return dto;

    }
}
