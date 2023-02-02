package com.example.ddooheeJpa.filter.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.example.ddooheeJpa.common.domain.BaseEntity;
import com.example.ddooheeJpa.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "UserGenderForFilter")
@Builder
@EntityListeners(AuditingEntityListener.class)
public class UserGenderForFilter extends BaseEntity {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserGenderForFilterIdx")
    private Long userGenderId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "Gender")
    private String gender;


}
