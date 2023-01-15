package com.example.ddooheeJpa.match.service;


import com.example.ddooheeJpa.domain.User.entity.User;
import com.example.ddooheeJpa.match.dto.MatchAllOkResDto;
import com.example.ddooheeJpa.match.dto.MatchNoResDto;
import com.example.ddooheeJpa.match.dto.MatchOkResDto;
import com.example.ddooheeJpa.match.dto.MatchingCreateResDto;

public interface MatchService {
    MatchingCreateResDto matching(long userMatching, long userGetMatched);
    MatchOkResDto matchOk(Long id);
    MatchNoResDto matchNo(Long id);
    MatchAllOkResDto matchAllOk(Long userGetMatched);
    MatchNoResDto matchDelete(Long id);
}
