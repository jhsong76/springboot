package com.example.ddooheeJpa.user.dto;


import com.example.ddooheeJpa.user.entity.UserInterest;
import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
public class UserListDto {
    private String userNickName;
    private String userMajorName;
    private String userStudentNum;
    private String userProfileImg;
    private int userLikeCount;

    private List<UserInterest> userInterests;
}
