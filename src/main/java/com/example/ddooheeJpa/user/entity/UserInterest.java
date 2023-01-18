package com.example.ddooheeJpa.user.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "userInterest")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor

public class UserInterest {
    @Id
    @Column(name ="userInterestIdx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Interest")
    private String Interest;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

//    @OneToMany(mappedBy = "userInterest" )
//    private List<UserInterest> userInterestList = new ArrayList<UserInterest>();



}
