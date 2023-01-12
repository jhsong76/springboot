package com.example.ddooheeJpa.domain.Match.Model;

import com.example.ddooheeJpa.domain.User.Model.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
public class MatchDTO {
    private User userGetMatched;
    private User userMatching;

    @Enumerated(EnumType.STRING)
    private userMatchStatus userMatchStatus; // 매칭 상태 [INACTIVE, ACTIVE]

    @Enumerated(EnumType.STRING)
    private MatchStatus status; // 매칭 테이블 컬럼 상태 [INACTIVE, ACTIVE]

}
