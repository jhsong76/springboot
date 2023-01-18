package com.example.ddooheeJpa.like.dto;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
public class LikeDto {
    private Long userGetMatched;
}
