package com.example.ddooheeJpa.match.service;


import com.example.ddooheeJpa.match.dto.*;

import java.util.List;

public interface MatchService {
    MatchingCreateResDto matching(long userMatching, long userGetMatched);
    MatchOkResDto matchOk(Long id);
    MatchNoResDto matchNo(Long id);
    MatchAllOkResDto matchAllOk(Long userGetMatched);
    MatchNoResDto matchDelete(Long id);
    List<GetMatchedUserListDto> GetMatchedList(Long userGetMatched);
}
