package com.example.ddooheeJpa.domain.Match.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
public class MatchDTO {
    private Long userGetMatched;
    private Long userMatching;

    @Enumerated(EnumType.STRING)
    private userMatchStatus userMatchStatus; // 매칭 상태 [INACTIVE, ACTIVE]

    @Enumerated(EnumType.STRING)
    private MatchStatus status; // 매칭 테이블 컬럼 상태 [INACTIVE, ACTIVE]

}
