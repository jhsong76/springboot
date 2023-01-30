package com.example.ddooheeJpa.filter.dto;

import com.example.ddooheeJpa.filter.entity.UserGenderForFilter;
import com.example.ddooheeJpa.filter.entity.UserGradeForFilter;
import com.example.ddooheeJpa.filter.entity.UserMajorForFilter;
import com.example.ddooheeJpa.filter.entity.UserMbtiForFilter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserFilterReqDto {
//    private List<UserGradeForFilter> blockedGrade;
//    private List<UserMajorForFilter> blockedMajor;
//    private List<UserMbtiForFilter> blockedMbti;

    private UserGradeForFilter Grade;
    private UserMajorForFilter blockedMajor;
    private UserMbtiForFilter blockedMbti;
    private UserGenderForFilter Gender;

    //    private String blockedGrade;
//    private String blockedMajor;
//    private String blockedMbti;
    //private int userGender;
}
