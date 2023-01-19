package com.example.ddooheeJpa.user.service;

import com.example.ddooheeJpa.like.converter.LikeConverter;
import com.example.ddooheeJpa.like.dto.LikeDto;
import com.example.ddooheeJpa.like.dto.ReqCreateUserLikeDto;
import com.example.ddooheeJpa.like.repository.LikesRepository;
import com.example.ddooheeJpa.match.converter.MatchConverter;

import com.example.ddooheeJpa.user.converter.Userconverter;

import com.example.ddooheeJpa.user.dto.UserResponseDto;
import com.example.ddooheeJpa.user.entity.User;
import com.example.ddooheeJpa.user.entity.UserInterest;
import com.example.ddooheeJpa.user.entity.UserLikes;
import com.example.ddooheeJpa.user.entity.UserPersonality;
import com.example.ddooheeJpa.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final Userconverter converter;
    private final LikesRepository likesRepository;
    private final LikeConverter likeConverter;
    private final MatchConverter matchConverter;
    //private final MbtiConverter mbtiConverter;


    @Override
    public UserResponseDto findById(final Long userId) {


        final User entity = userRepository.getReferenceById(userId);
        final long userLikes = likesRepository.countByUserGetLikes(userId);
        return getUserResponseDto(entity, userLikes);



    }

    private UserResponseDto getUserResponseDto(final User entity, final long userLikes) {
        return converter.toResponseDto(
                converter.toDto(entity),
                entity.getUserInterests()
                        .stream()
                        .map(UserInterest::getInterest)
                                .collect(Collectors.toList()),

        entity.getUserPesonalitys()
                .stream()
                .map(UserPersonality::getPersonality)
                .collect(Collectors.toList()));

    }

    @Transactional
    public ReqCreateUserLikeDto userLikes(final long userGiveLike, final long userGetLike){
        User Give = userRepository.findById(userGiveLike).get();
        User Get = userRepository.findById(userGetLike).get();
        final UserLikes userLikes = likesRepository
                .save(likeConverter.ReqCreateUserLikeDto(Give, Get));
        return likeConverter.ResCreateUserLikeDto(userLikes);
    }

}
