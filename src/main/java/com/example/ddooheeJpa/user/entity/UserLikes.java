package com.example.ddooheeJpa.user.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Table(name = "userLikes")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@SuperBuilder
public class UserLikes {
    @Id
    @Column(name ="userLikesIdx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userGetLikes")
    private User userGetLikes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userGiveLikes")
    private User userGiveLikes;

    @Enumerated(EnumType.STRING)
    private UserLikesStatus status;
}
