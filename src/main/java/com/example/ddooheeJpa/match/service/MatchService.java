package com.example.ddooheeJpa.match.service;

import com.example.ddooheeJpa.common.exception.LInkyBussinessException;
import com.example.ddooheeJpa.match.converter.MatchConverter;
import com.example.ddooheeJpa.match.dto.MatchDto;
import com.example.ddooheeJpa.match.repository.MatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MatchService {

    private final MatchConverter matchConverter;
    private final MatchRepository matchRepository;

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

}
