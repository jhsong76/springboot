package com.example.ddooheeJpa.user.dto;

import com.example.ddooheeJpa.match.controller.MatchController;
import com.example.ddooheeJpa.user.entity.User;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class UserStudentDto {
    private Long userId;
    private String userNickName;
    private String userMajorName;
    private String userStudentNum;
    private String userprofileImg;
    private List<MatchController.UserInterestDto> userInterests;


    public UserStudentDto(User user) {
        userId = user.getUserId();
        userNickName = user.getUserNickName();
        userMajorName = user.getUserMajorName();
        userStudentNum = user.getUserStudentNum();

        userprofileImg = user.getUserProfileImg();

        userInterests = user.getUserInterests().stream()
                .map(userInterest -> new MatchController.UserInterestDto(userInterest))
                .collect(Collectors.toList());


    }

}
