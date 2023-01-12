package com.example.ddooheeJpa.domain.Match.Model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "usermatch")
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userMatchIdx")
    private Long id;

    private Long userGetMatched; // 연결을 당한 유저
    private Long userMatching; // 연결을 시도한 유저


    @Enumerated(EnumType.STRING)
    private userMatchStatus userMatchStatus; // 매칭 상태 [INACTIVE, ACTIVE]

    @Enumerated(EnumType.STRING)
    private MatchStatus status; // 매칭 테이블 컬럼 상태 [INACTIVE, ACTIVE]

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;



}
