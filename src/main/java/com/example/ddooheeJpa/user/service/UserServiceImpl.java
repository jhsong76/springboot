package com.example.ddooheeJpa.user.service;

import com.example.ddooheeJpa.like.converter.LikeConverter;
import com.example.ddooheeJpa.like.dto.LikeDto;
import com.example.ddooheeJpa.like.dto.ReqCreateUserLikeDto;
import com.example.ddooheeJpa.like.repository.LikesRepository;
import com.example.ddooheeJpa.match.converter.MatchConverter;
import com.example.ddooheeJpa.match.dto.MatchDto;
import com.example.ddooheeJpa.match.entity.Match;
import com.example.ddooheeJpa.mbti.converter.MbtiConverter;
import com.example.ddooheeJpa.mbti.dto.MbtiDto;
import com.example.ddooheeJpa.mbti.entity.UserMbti;
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
    private final MbtiConverter mbtiConverter;


    @Override
    public UserResponseDto findById(final Long userId) {

//        UserResponseDto dto = userRepository.findById(userId)
//                .map(converter::toDto)
//                .orElseThrow(() -> new BaseException(NOT_USER));
//
//        System.out.println(dto);
//        return dto;

        User user = userRepository.findUserByUserId(userId);



        final User entity = userRepository.getReferenceById(userId);
        return getUserResponseDto(entity);



    }

    private UserResponseDto getUserResponseDto(final User entity) {
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
                //entity.getUserMbti().getMbti());
//                entity.getUserLikesIdx().getUserGetLikes(),
//                entity.getUserMatchIdx().getUserGetMatched(),


    }

    @Transactional
    public ReqCreateUserLikeDto userLikes(final long userGiveLike, final long userGetLike){
        User Give = userRepository.findById(userGiveLike).get();
        User Get = userRepository.findById(userGetLike).get();
        final UserLikes userLikes = likesRepository
                .save(likeConverter.ReqCreateUserLikeDto(Give, Get));
        //System.out.println(U);
        return likeConverter.ResCreateUserLikeDto(userLikes);
    }

}
