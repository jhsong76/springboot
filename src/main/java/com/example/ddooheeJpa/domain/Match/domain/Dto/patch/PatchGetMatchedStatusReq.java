package com.example.ddooheeJpa.domain.Match.domain.Dto.patch;

import com.example.ddooheeJpa.domain.Match.domain.userMatchStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@NoArgsConstructor
@Data
public class PatchGetMatchedStatusReq {
    @Enumerated(EnumType.STRING)
    private userMatchStatus userMatchStatus;
}
