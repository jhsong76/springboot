package com.example.ddooheeJpa.filter.entity;

import com.example.ddooheeJpa.user.entity.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "UserMajorForFilter")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserMajorForFilter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userMajorIdx")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "blockedMajor")
    private String blockedMajor;
}
