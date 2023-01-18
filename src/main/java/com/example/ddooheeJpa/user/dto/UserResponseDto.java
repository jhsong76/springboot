package com.example.ddooheeJpa.user.dto;

import com.example.ddooheeJpa.user.entity.User;
import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
public class UserResponseDto {
    private Long userId;
   // private String userPhoneNum;
    private String userNickName;
    private String userMajorName;
    private String userStudentNum;
    private int userGender;
    private String userInfo;
    private String userProfileImg;
    private String userMbti;
    private List<String> userInterests;
    private List<String> userPersonalitys;

//    private User userLikes;
//    private User userMatch;


}
