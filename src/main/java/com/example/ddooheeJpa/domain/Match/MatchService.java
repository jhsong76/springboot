package com.example.ddooheeJpa.domain.Match;

import com.example.ddooheeJpa.config.BaseException;
import com.example.ddooheeJpa.config.BaseResponseStatus;
import com.example.ddooheeJpa.domain.Match.domain.Dto.patch.PatchGetMatchedStatusReq;
import com.example.ddooheeJpa.domain.Match.domain.Match;
import com.example.ddooheeJpa.domain.Match.domain.MatchDTO;
import com.example.ddooheeJpa.domain.Match.domain.MatchMapper;
import com.example.ddooheeJpa.domain.User.Model.User;
import com.example.ddooheeJpa.domain.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)

public class MatchService {


    private static MatchRepository matchRepository ;
    private final UserRepository userRepository;
    private final MatchMapper matchMapper;

    public MatchService(MatchRepository matchRepository, UserRepository userRepository, MatchMapper matchMapper) {
        this.matchRepository = matchRepository;
        this.userRepository = userRepository;
        this.matchMapper = matchMapper;
    }

    @Transactional
    public Match match(MatchDTO dto) {
        Match match = matchMapper.toEntity(dto);
        matchRepository.save(match);

        return match;
    }

    public static List<Match> getMetched(Long user_id) {
        List<Match> matches = matchRepository.findUserGetMatchingByUserId(user_id);
        return matches;
    }

    // 매칭 수락
    @Transactional
    public Match updateGetMatchedStatus(Long id, PatchGetMatchedStatusReq dto) {

        // PathVariable로 조회
        Match findUser = matchRepository
        .findById(id)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_USER));

        findUser.updateGetMatchedStatus(dto.getUserMatchStatus());
        return findUser;

    }

}
