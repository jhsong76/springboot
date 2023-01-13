package com.example.ddooheeJpa.domain.Like;

import com.example.ddooheeJpa.domain.User.Model.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "userLike")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userLikeIdx")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "userGetLike")
    private User userGetLike; // 좋아요 당한 유저

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "userGiveLike")
    private User userGiveLike; // 좋아요 시도한 유저


    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
