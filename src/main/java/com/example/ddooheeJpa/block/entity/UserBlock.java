package com.example.ddooheeJpa.block.entity;


import com.example.ddooheeJpa.match.entity.status;
import com.example.ddooheeJpa.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "UserBlock")
@SuperBuilder
public class UserBlock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userBlockIdx")
    private Long blockId;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "userGiveBlock")
    private User userGiveBlock;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "userGetBlocked")
    private User userGetBlocked;

    @Enumerated(EnumType.STRING)
    private userBlockStatus blockStatus;

    public void updateBlock(userBlockStatus blockStatus) {
        this.blockStatus = blockStatus;
    }


}

