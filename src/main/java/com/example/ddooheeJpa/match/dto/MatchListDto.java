package com.example.ddooheeJpa.match.dto;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
public class MatchListDto {
    private long userGetMatched;
}
