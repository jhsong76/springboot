package com.example.ddooheeJpa.domain.Personality.entity;

import com.example.ddooheeJpa.domain.User.entity.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "userPersonality")
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Personality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userPersonalityIdx")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "userIdx")
    private User userIdx;

    private String personality;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
