package com.example.ddooheeJpa.filter.entity;

import com.example.ddooheeJpa.user.entity.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "userMbtiForFilter")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserMbtiForFilter {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userMbtiIdx")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "blockedMbti")
    private String blockedMbti;
}
