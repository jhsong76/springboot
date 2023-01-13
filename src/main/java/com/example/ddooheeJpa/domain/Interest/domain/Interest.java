package com.example.ddooheeJpa.domain.Interest.domain;

import com.example.ddooheeJpa.domain.User.Model.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "userInterest")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Interest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userInterestIdx")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "userIdx")
    private User userIdx;

    private String interest;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
