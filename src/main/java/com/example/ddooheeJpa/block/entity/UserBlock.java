package com.example.ddooheeJpa.block.entity;



import com.example.ddooheeJpa.common.domain.BaseEntity;
import com.example.ddooheeJpa.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "UserBlock")
@Builder
public class UserBlock extends BaseEntity {

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
