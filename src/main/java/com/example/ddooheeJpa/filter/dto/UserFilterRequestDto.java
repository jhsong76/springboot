package com.example.ddooheeJpa.filter.dto;

import com.example.ddooheeJpa.filter.entity.UserGenderForFilter;
import com.example.ddooheeJpa.filter.entity.UserGradeForFilter;
import com.example.ddooheeJpa.filter.entity.UserMajorForFilter;
import com.example.ddooheeJpa.filter.entity.UserMbtiForFilter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserFilterRequestDto {

    private List<UserGradeForFilter> grade;
    private List<UserMajorForFilter> blockedMajor;
    private List<UserMbtiForFilter> blockedMbti;
    private List<UserGenderForFilter> gender;

}
