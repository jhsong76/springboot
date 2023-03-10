package com.example.ddooheeJpa.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.example.ddooheeJpa.common.domain.BaseEntity;
import com.example.ddooheeJpa.filter.entity.UserGenderForFilter;
import com.example.ddooheeJpa.filter.entity.UserGradeForFilter;
import com.example.ddooheeJpa.filter.entity.UserMajorForFilter;
import com.example.ddooheeJpa.filter.entity.UserMbtiForFilter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "User")
@EntityListeners(AuditingEntityListener.class)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", insertable = false, updatable = false)
    private Long userId;

    private String userPhoneNum;
    private String userNickName;
    private String userBirth;
    private String SchoolName;
    private String userMajorName;
    private String userStudentNum;
    private String userGender;
    private String userMbti;
    private String userInfo;
    private String userProfileImg;

    @Enumerated(EnumType.STRING)
    private UserNotification userNotification; // 유저 알림 설정 상태 [INACTIVE, ACTIVE]

    @Enumerated(EnumType.STRING)
    private UserStatusForMyInfo userStatusForMyInfo; // 유저 정보 활성화 상태 [INACTIVE, ACTIVE]

    @Convert(converter=BooleanToYNConverter.class)
    private boolean gradStatus;

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<UserInterest> userInterests;

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<UserPersonality>  userPersonalities;

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = LAZY)
    private List<UserGradeForFilter> userGradeForFilters;

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = LAZY)
    private List<UserMajorForFilter> userMajorForFilters;

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = LAZY)
    private List<UserMbtiForFilter> userMbtiForFilters;

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = LAZY)
    private List<UserGenderForFilter> userGenderForFilters;
    private int userLikeCount;
    private int userMatchingCount;

    public void UserLikeCount() {
        this.userLikeCount++;
    }

    public void UserMatchingCount() {
        this.userMatchingCount++;
    }

    public void updateStatusForMyInfo(UserStatusForMyInfo userStatusForMyInfo) {
        this.userStatusForMyInfo = userStatusForMyInfo;
    }

    public void updateUserNotification(UserNotification userNotification) {
        this.userNotification = userNotification;
    }

}
