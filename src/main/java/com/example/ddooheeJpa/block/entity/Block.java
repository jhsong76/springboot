package com.example.ddooheeJpa.block.entity;


import com.example.ddooheeJpa.domain.User.entity.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "userBlock")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
public class Block {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userBlockIdx")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "userGiveBlock")
    private User userGiveBlock;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "userGetBlocked")
    private User userGetBlocked;

    @Enumerated(EnumType.STRING)
    private userBlockStatus status;

}
