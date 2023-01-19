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

    @Convert(converter=BooleanToYNConverter.class)
    private boolean gradStatus;


    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<UserInterest> userInterests = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<UserPersonality> userPesonalitys = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false)
    private UserLikes userLikeCount;

}
