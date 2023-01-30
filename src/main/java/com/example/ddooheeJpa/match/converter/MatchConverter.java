package com.example.ddooheeJpa.match.converter;

import com.example.ddooheeJpa.match.entity.UserMatch;
import com.example.ddooheeJpa.match.entity.status;
import com.example.ddooheeJpa.match.entity.userMatchStatus;
import org.springframework.stereotype.Component;

@Component
public class MatchConverter {
    public UserMatch tryMatching(final User userMatching, final User userGetMatched) {
        return UserMatch.builder()
                .userMatching(userMatching)
                .userGetMatched(userGetMatched)
                .userMatchStatus(userMatchStatus.INACTIVE)
                .status(status.ACTIVE)
                .build();
    }
}
