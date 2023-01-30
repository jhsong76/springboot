package com.example.ddooheeJpa.match.entity;

import com.linkyB.backend.common.domain.BaseEntity;
import com.linkyB.backend.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "UserMatch")
@Builder
@EntityListeners(AuditingEntityListener.class)
public class UserMatch extends BaseEntity {

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

    public void update(userMatchStatus userMatchStatus) {

        this.userMatchStatus = userMatchStatus;
    }

    public void updateMatch(status status) {
        this.status = status;
    }

}
