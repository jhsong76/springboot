package com.example.ddooheeJpa.user.dto;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
public class Dto {
    private Long userId;
    //private String userPhoneNum;
    private String userNickName;
    private String userMajorName;
    private String userStudentNum;
    private int userGender;
    private String userInfo;
    private String userProfileImg;
    private String userMbti;
}
