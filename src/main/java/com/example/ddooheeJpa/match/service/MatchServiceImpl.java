package com.example.ddooheeJpa.match.service;

import com.example.ddooheeJpa.block.converter.Blockconverter;
import com.example.ddooheeJpa.block.entity.Block;

import com.example.ddooheeJpa.block.repository.BlockRepository;
import com.example.ddooheeJpa.interest.repository.InterestRepository;
import com.example.ddooheeJpa.like.repository.LikesRepository;
import com.example.ddooheeJpa.user.converter.Userconverter;
import com.example.ddooheeJpa.user.entity.User;
import com.example.ddooheeJpa.user.repository.UserRepository;
import com.example.ddooheeJpa.match.converter.MatchConverter;
import com.example.ddooheeJpa.match.dto.*;
import com.example.ddooheeJpa.match.entity.Match;
import com.example.ddooheeJpa.match.entity.status;
import com.example.ddooheeJpa.match.entity.userMatchStatus;
import com.example.ddooheeJpa.match.repository.MatchRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MatchServiceImpl implements MatchService {

    private final MatchRepository matchRepository;
    private final MatchConverter matchConverter;
    private final BlockRepository blockRepository;
    private final Blockconverter blockconverter;
    private final UserRepository userRepository;
    private final Userconverter userconverter;
    private final InterestRepository interestRepository;
    private final LikesRepository likesRepository;

    // 매칭 시도
    @Transactional
    public MatchResDto matching(final long userMatching, final long userGetMatched) {
        User Matching = userRepository.findById(userMatching).get();
        User GetMatched = userRepository.findById(userGetMatched).get();
        final Match match = matchRepository
                .save(matchConverter.ReqCreateMatchDto(Matching, GetMatched));
        return matchConverter.ResCreateMatchDto(match);
    }

    // 매칭 수락
    @Transactional
    public MatchResDto matchOk(Long id) {
        Match match = matchRepository.getById(id);
        match.update(userMatchStatus.ACTIVE);
        return matchConverter.ResMatchOkDto(match);
    }

    // 매칭 거절
    @Transactional
    public MatchResDto matchNo(Long id) {
        Match match = matchRepository.getById(id);
        match.updateMatch(status.INACTIVE);
        Block block = blockRepository.save(blockconverter.ReqMatchNoDto(match.getUserMatching(), match.getUserGetMatched()));
        return blockconverter.ResMatchNoDto(block);
    }

    // 매칭 모두 수락
    @Transactional
    public MatchAllOkResDto matchAllOk(Long userGetMatched) {
        matchRepository.updateMatchStatusByUserGetMatched(userGetMatched);
        return matchConverter.ResMatchAllOkDto(userGetMatched);
    }

    // 내가 매칭 시도한 내역 삭제
    @Transactional
    public MatchResDto matchDelete(Long id) {
        Match match = matchRepository.getById(id);
        match.updateMatch(status.INACTIVE);
        match.update(userMatchStatus.INACTIVE);
        Block block = blockRepository.save(blockconverter.ReqMatchdeleteDto(match.getUserMatching(), match.getUserGetMatched()));
        return blockconverter.ResMatchNoDto(block);
    }

    public List<UserMatchList> GetMatchedList(Long userGetMatched) {

        List<UserMatchList> findUser = userRepository.getUsersByUserId(userGetMatched);
        return findUser;

    }



}
