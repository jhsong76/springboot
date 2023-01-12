package com.example.ddooheeJpa.domain.Match;

import com.example.ddooheeJpa.domain.Match.Model.Dto.get.getMatchListRes;
import com.example.ddooheeJpa.domain.Match.Model.Match;
import com.example.ddooheeJpa.domain.Match.Model.MatchDTO;
import com.example.ddooheeJpa.domain.Match.Model.MatchMapper;
import com.example.ddooheeJpa.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MatchService {

    private final MatchRepository matchRepository;
    private final UserRepository userRepository;
    private final MatchMapper matchMapper;

  /*  @Transactional
    public Match match(MatchDTO dto) {
        Match match = matchMapper.toEntity(dto);
        matchRepository.save(match);

        return match;
    }*/

    public List<Match> matchList(Long user_id) {
        return matchRepository.findAll(user_id);
    }
}
