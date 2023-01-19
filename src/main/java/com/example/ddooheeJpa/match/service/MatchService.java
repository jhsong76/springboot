package com.example.ddooheeJpa.match.service;


import com.example.ddooheeJpa.match.dto.*;

import java.util.List;

public interface MatchService {
    MatchResDto matching(long userMatching, long userGetMatched);
    MatchResDto matchOk(Long id);
    MatchResDto matchNo(Long id);
    MatchAllOkResDto matchAllOk(Long userGetMatched);
    MatchResDto matchDelete(Long id);
    List<UserMatchList> GetMatchedList(Long userGetMatched);
}
