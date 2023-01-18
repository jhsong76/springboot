package com.example.ddooheeJpa.mbti.converter;

import com.example.ddooheeJpa.mbti.dto.MbtiDto;
import com.example.ddooheeJpa.mbti.entity.UserMbti;
import org.springframework.stereotype.Component;

@Component
public class MbtiConverter {

    public MbtiDto toDto(final UserMbti entity) {
        return MbtiDto.builder()
                .mbti(entity.getMbti())
                .build();
    }
}
