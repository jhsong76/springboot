package com.example.ddooheeJpa.filter.dto;

import com.example.ddooheeJpa.filter.entity.UserGenderForFilter;
import com.example.ddooheeJpa.filter.entity.UserGradeForFilter;
import com.example.ddooheeJpa.filter.entity.UserMajorForFilter;
import com.example.ddooheeJpa.filter.entity.UserMbtiForFilter;
import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
public class UserFilterDto {

    private List<UserGenderForFilter> userGenderForFilters;
    private List<UserGradeForFilter> userGradeForFilters;
    private List<UserMajorForFilter> userMajorForFilters;
    private List<UserMbtiForFilter> userMbtiForFilters;

}
