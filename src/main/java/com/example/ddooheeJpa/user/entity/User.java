package com.example.ddooheeJpa.user.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "User")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", insertable = false, updatable = false)
    private Long userId;

    private String userPhoneNum;
    private String userNickName;
    private String userBirth;
    private String SchoolName;
    private String userMajorName;
    private String userStudentNum;
    private int userGender;
    private String userMbti;
    private String userPersonality;

    private String userInfo;
    private String userProfileImg;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<UserInterest> userInterests;



    //@OneToMany(mappedBy = "Match")
    //private List<Match> matches = new ArrayList<>();

}
