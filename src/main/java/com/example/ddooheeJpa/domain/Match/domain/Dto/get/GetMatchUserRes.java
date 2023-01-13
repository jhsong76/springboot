package com.example.ddooheeJpa.domain.Match.domain.Dto.get;

import com.example.ddooheeJpa.domain.User.Model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetMatchUserRes {
    private String userNickName;
    private String userProfileImg;
    private String userMajorName;
    private String userStudentNum;



    public GetMatchUserRes(String userNickName, String userProfileImg, String userMajorName, String userStudentNum) {
        this.userNickName = userNickName;
        this.userProfileImg = userProfileImg;
        this.userMajorName = userMajorName;
        this.userStudentNum = userStudentNum;

    }

    public static GetMatchUserRes of(User user) {
        return new GetMatchUserRes(
                user.getUserNickName(),
                user.getUserProfileImg(),
                user.getUserMajorName(),
                user.getUserStudentNum());

    }
}
