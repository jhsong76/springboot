package com.example.ddooheeJpa.user.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "UserPersonality")
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserPersonality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userPersonalityIdx")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "userIdx")
    private User userIdx;

    private String personality;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}