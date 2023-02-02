package com.example.ddooheeJpa.like.entity;

import com.example.ddooheeJpa.common.domain.BaseEntity;
import com.example.ddooheeJpa.user.entity.User;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "userLikes")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class UserLikes extends BaseEntity {
    @Id
    @Column(name ="userLikesIdx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userGetLikes")
    private User userGetLikes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userGiveLikes")
    private User userGiveLikes;

    @Enumerated(EnumType.STRING)
    private UserLikesStatus status;
}
