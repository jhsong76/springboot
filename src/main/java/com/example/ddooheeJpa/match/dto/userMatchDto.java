package com.example.ddooheeJpa.match.dto;


import com.example.ddooheeJpa.match.entity.status;
import com.example.ddooheeJpa.match.entity.userMatchStatus;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
public class userMatchDto {

    private Long id;
    private Long userGetMatched;
    private Long userMatching;
    private com.example.ddooheeJpa.match.entity.userMatchStatus userMatchStatus;
    private com.example.ddooheeJpa.match.entity.status status;

}
