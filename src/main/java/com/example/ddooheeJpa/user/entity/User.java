package com.example.ddooheeJpa.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "User")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor

public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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


    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<UserInterest> userInterests = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<UserPersonality> userPesonalitys = new ArrayList<>();

//    @OneToOne
//    @JoinColumn(name = "userMbtiIdx")
//    private UserMbti userMbti;
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    //@JoinColumn(name = "id", nullable = false)
//    private UserLikes userLikesIdx;
//
    //@ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "userMbtiIdx",  nullable = false)
//    private UserMbti userMbtiIdx;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    //@JoinColumn(name = "id",  nullable = false)
//    private Match userMatchIdx;


//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//    private List<String> userinterests;

    //@OneToMany(mappedBy = "Match")
    //private List<Match> matches = new ArrayList<>();

}
