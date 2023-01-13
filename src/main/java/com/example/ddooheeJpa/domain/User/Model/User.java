package com.example.ddooheeJpa.domain.User.Model;

import com.example.ddooheeJpa.domain.Like.Like;
import com.example.ddooheeJpa.domain.Match.domain.Match;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "User")
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
    private String userInterest;
    private String userInfo;
    private String userProfileImg;
    //private long userLike;

    //@OneToMany(mappedBy = "Match")
    //private List<Match> matches = new ArrayList<>();

}
