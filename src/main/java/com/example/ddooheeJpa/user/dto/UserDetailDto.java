package com.example.ddooheeJpa.user.dto;

import com.example.ddooheeJpa.user.entity.UserInterest;
import com.example.ddooheeJpa.user.entity.UserPersonality;
import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder

public class UserDetailDto {
    private Long userId;
    private String userNickName;
    private String userMajorName;
    private String userStudentNum;
    private int userGender;
    private String userInfo;
    private String userProfileImg;
    private String userMbti;
    private List<UserInterest> userInterests;
    private List<UserPersonality> userPersonalities;
    private int userLikeCount;

}
