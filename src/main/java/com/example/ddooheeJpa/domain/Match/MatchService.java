package com.example.ddooheeJpa.domain.Match;

import com.example.ddooheeJpa.domain.Match.Model.Match;
import com.example.ddooheeJpa.domain.Match.Model.MatchDTO;
import com.example.ddooheeJpa.domain.Match.Model.MatchMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MatchService {

    private final MatchRepository matchRepository;
    private final MatchMapper matchMapper;

    @Transactional
    public Match match(MatchDTO dto) {
        Match match = matchMapper.toEntity(dto);
        matchRepository.save(match);

        return match;
    }
}
