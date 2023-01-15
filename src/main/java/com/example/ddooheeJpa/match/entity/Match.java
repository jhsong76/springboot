package com.example.ddooheeJpa.match.entity;


import com.example.ddooheeJpa.domain.User.entity.User;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "userMatch")
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userMatchIdx")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "userGetMatched")
    private User userGetMatched; // 연결을 당한 유저

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "userMatching")
    private User userMatching; // 연결을 시도한 유저


    @Enumerated(EnumType.STRING)
    private userMatchStatus userMatchStatus; // 매칭 상태 [INACTIVE, ACTIVE]

    @Enumerated(EnumType.STRING)
    private status status; // 매칭 테이블 컬럼 상태 [INACTIVE, ACTIVE]

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


    public void update(userMatchStatus userMatchStatus) {

        this.userMatchStatus = userMatchStatus;
    }

    public void updateMatch(status status){
        this.status = status;
    }

    public void updateGetMatchedStatus(userMatchStatus userMatchStatus) {
        this.userMatchStatus = userMatchStatus;
    }


}
