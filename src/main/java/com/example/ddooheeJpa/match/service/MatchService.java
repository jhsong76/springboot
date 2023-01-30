package com.example.ddooheeJpa.match.service;

import com.example.ddooheeJpa.block.converter.Blockconverter;
import com.example.ddooheeJpa.block.dto.BlockDto;
import com.example.ddooheeJpa.block.entity.UserBlock;
import com.example.ddooheeJpa.block.mapper.BlockMapper;
import com.example.ddooheeJpa.block.repository.BlockRepository;
import com.example.ddooheeJpa.common.exception.LInkyBussinessException;
import com.example.ddooheeJpa.home.repository.PagingRepository;
import com.example.ddooheeJpa.match.converter.MatchConverter;
import com.example.ddooheeJpa.match.dto.MatchDto;
import com.example.ddooheeJpa.match.dto.MatchListDto;
import com.example.ddooheeJpa.match.entity.UserMatch;
import com.example.ddooheeJpa.match.entity.status;
import com.example.ddooheeJpa.match.entity.userMatchStatus;
import com.example.ddooheeJpa.match.mapper.MatchMapper;
import com.example.ddooheeJpa.match.repository.MatchRepository;
import com.example.ddooheeJpa.user.dto.UserListDto;
import com.example.ddooheeJpa.user.entity.User;
import com.example.ddooheeJpa.user.mapper.UserMapper;
import com.example.ddooheeJpa.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MatchService {

    private final MatchRepository matchRepository;
    private final UserRepository userRepository;
    private final MatchConverter matchConverter;
    private final BlockRepository blockRepository;
    private final Blockconverter blockconverter;
    private final PagingRepository pagingRepository;

    // 매칭 시도
    @Transactional
    public MatchDto matching(long userMatching, long userGetMatched) {

        User Matching = userRepository.findById(userMatching)
                .orElseThrow(() -> new LInkyBussinessException("해당 유저가 존재하지 않습니다.", HttpStatus.BAD_REQUEST));
        User GetMatched = userRepository.findById(userGetMatched)
                .orElseThrow(() -> new LInkyBussinessException("해당 유저가 존재하지 않습니다.", HttpStatus.BAD_REQUEST));

        UserMatch entity = matchRepository.save(matchConverter.tryMatching(Matching, GetMatched));
        MatchDto dto = MatchMapper.INSTANCE.entityToDto(entity);

        return dto;
    }

    // 매칭 수락
    @Transactional
    public MatchDto matchOk(long id) {

        UserMatch entity = matchRepository.findById(id)
                .orElseThrow(() -> new LInkyBussinessException("해당 연결내역이 존재하지 않습니다.", HttpStatus.BAD_REQUEST));

        entity.update(userMatchStatus.ACTIVE);
        MatchDto dto = MatchMapper.INSTANCE.entityToDto(entity);

        return dto;
    }

    // 매칭 거절
    @Transactional
    public BlockDto matchNo(Long id) {

        UserMatch entity = matchRepository.findById(id)
                .orElseThrow(() -> new LInkyBussinessException("해당 연결내역이 존재하지 않습니다.", HttpStatus.BAD_REQUEST));

        entity.updateMatch(status.INACTIVE);

        UserBlock block = blockRepository.save(blockconverter.block(entity.getUserGetMatched(), entity.getUserMatching()));
        BlockDto dto = BlockMapper.INSTANCE.entityToDto(block);
        return dto;
    }

    // 매칭 모두 수락
    @Transactional
    public MatchListDto matchAllOk(Long userGetMatched) {

        userRepository.findById(userGetMatched)
                .orElseThrow(() -> new LInkyBussinessException("해당 유저가 존재하지 않습니다.", HttpStatus.BAD_REQUEST));

        matchRepository.updateUserByUserGetMatched(userGetMatched);
        MatchListDto match = matchConverter.MatchAllokResponseDto(userGetMatched);

        return match;
    }

    // 내가 매칭 시도한 내역 삭제
    @Transactional
    public BlockDto matchDelete(Long id) {

        UserMatch match = matchRepository.findById(id)
                .orElseThrow(() -> new LInkyBussinessException("해당 연결내역이 존재하지 않습니다.", HttpStatus.BAD_REQUEST));

        match.updateMatch(status.INACTIVE);
        match.update(userMatchStatus.INACTIVE);

        UserBlock block = blockRepository.save(blockconverter.blockGetMatched(match.getUserMatching(), match.getUserGetMatched()));
        BlockDto dto = BlockMapper.INSTANCE.entityToDto(block);
        return dto;
    }

    // 나에게 매칭 시도한 유저 전체 조회
    public List<UserListDto> GetMatchedList(Long userGetMatched) {

        userRepository.findById(userGetMatched)
                .orElseThrow(() -> new LInkyBussinessException("해당 유저가 존재하지 않습니다.", HttpStatus.BAD_REQUEST));

        List<User> users = userRepository.findAllByUserGetMatched(userGetMatched);
        List<UserListDto> dto = UserMapper.INSTANCE.entityToDtoList(users);

        return dto;
    }

    // 내가 매칭 시도한 유저 전체 조회
    public List<UserListDto> MatchingList(Long userMatching) {

        userRepository.findById(userMatching)
                .orElseThrow(() -> new LInkyBussinessException("해당 유저가 존재하지 않습니다.", HttpStatus.BAD_REQUEST));

        List<User> users = userRepository.findAllByUserMatching(userMatching);
        List<UserListDto> dto = UserMapper.INSTANCE.entityToDtoList(users);

        return dto;
    }

    // 나에게 연결을 시도한 회원 -> getMatched == 나
    public List<UserListDto> homeGetMatchedList(long userId) {
        List<User> userList = userRepository.findTop4ByUserGetMatched(userId);
        List<UserListDto> listdto = UserMapper.INSTANCE.entityToDtoList(userList);

        return listdto;
    }

    // 내가 연결을 시도한 회원 -> Matching == 나
    public List<UserListDto> homeMatchingList(long userId) {
        List<User> userList = userRepository.findTop4ByUserMatching(userId);
        List<UserListDto> listdto = UserMapper.INSTANCE.entityToDtoList(userList);

        return listdto;
    }
}
