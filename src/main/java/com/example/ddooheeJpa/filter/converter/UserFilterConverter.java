package com.example.ddooheeJpa.filter.converter;

import com.example.ddooheeJpa.filter.entity.UserGenderForFilter;
import com.example.ddooheeJpa.filter.entity.UserGradeForFilter;
import com.example.ddooheeJpa.filter.entity.UserMajorForFilter;
import com.example.ddooheeJpa.filter.entity.UserMbtiForFilter;
import com.example.ddooheeJpa.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserFilterConverter {

    public UserGenderForFilter filterSave(final User userId, final UserGenderForFilter dto) {
        return UserGenderForFilter.builder()
                .user(userId)
                .gender(dto.getGender())
                .build();
    }

    public UserMbtiForFilter mbtiFiltersave(final User user, final UserMbtiForFilter dto) {
        return UserMbtiForFilter.builder()
                .user(user)
                .blockedMbti(dto.getBlockedMbti())
                .build();
    }


    public UserGradeForFilter gradeFiltersave(final User user, final UserGradeForFilter dto) {
        return UserGradeForFilter.builder()
                .user(user)
                .grade(dto.getGrade())
                .build();
    }

    public UserMajorForFilter majorFiltersave(final User user, final UserMajorForFilter dto) {
        return UserMajorForFilter.builder()
                .user(user)
                .blockedMajor(dto.getBlockedMajor())
                .build();
    }


}
