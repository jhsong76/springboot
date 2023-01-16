package com.example.ddooheeJpa.match.service;

import com.example.ddooheeJpa.block.converter.Blockconverter;
import com.example.ddooheeJpa.block.entity.Block;

import com.example.ddooheeJpa.block.repository.BlockRepository;
import com.example.ddooheeJpa.interest.repository.InterestRepository;
import com.example.ddooheeJpa.like.repository.LikesRepository;
import com.example.ddooheeJpa.user.converter.Userconverter;
import com.example.ddooheeJpa.user.entity.User;
import com.example.ddooheeJpa.user.entity.UserInterest;
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
import java.util.stream.Collectors;

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

    @Transactional
    public MatchingCreateResDto matching(final long userMatching, final long userGetMatched) {
        User Matching = userRepository.findById(userMatching).get();
        User GetMatched = userRepository.findById(userGetMatched).get();
        final Match match = matchRepository
                .save(matchConverter.ReqCreateMatchDto(Matching, GetMatched));
        return matchConverter.ResCreateMatchDto(match);
    }

    @Transactional
    public MatchOkResDto matchOk(Long id) {
        Match match = matchRepository.getById(id);
        match.update(userMatchStatus.ACTIVE);
        return matchConverter.ResMatchOkDto(match);
    }

    @Transactional
    public MatchNoResDto matchNo(Long id) {
        Match match = matchRepository.getById(id);
        match.updateMatch(status.INACTIVE);
        Block block = blockRepository.save(blockconverter.ReqMatchNoDto(match.getUserMatching(), match.getUserGetMatched()));
        return blockconverter.ResMatchNoDto(block);
    }

    @Transactional
    public MatchAllOkResDto matchAllOk(Long userGetMatched) {
        matchRepository.updateMatchStatusByUserGetMatched(userGetMatched);
        return matchConverter.ResMatchAllOkDto(userGetMatched);
    }

    @Transactional
    public MatchNoResDto matchDelete(Long id) {
        Match match = matchRepository.getById(id);
        match.updateMatch(status.INACTIVE);
        match.update(userMatchStatus.INACTIVE);
        Block block = blockRepository.save(blockconverter.ReqMatchdeleteDto(match.getUserMatching(), match.getUserGetMatched()));
        return blockconverter.ResMatchNoDto(block);
    }

    public List<GetMatchedUserListDto> GetMatchedList(Long userGetMatched) {

//        User GetMatched = userRepository.findById(userGetMatched).get();
//        final Match match = matchRepository.findByUserGetMatched(GetMatched);
//        final User entity = userRepository.getReferenceById(userGetMatched);

        //User GetMatched = userRepository.findById(userGetMatched).get();
        //List<Match> userMatching = matchRepository.findUserMatchingByUserGetMatched(userGetMatched);

        //List<User> user = userRepository.getUsersByUserId(userGetMatched);

        //int userLike = likeRepository.CountByUser(userGetMatched);
        //int userLike = 2;

        return matchConverter.GetMatchedListResponseDto(userRepository.getUsersByUserId(userGetMatched),
                interestRepository.getUserInterestsByUser(userGetMatched), likesRepository.countByUserGetLikes(userGetMatched));

    }


}
