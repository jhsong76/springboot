package com.example.ddooheeJpa.domain.Match.domain.Dto.get;

import com.example.ddooheeJpa.domain.Match.domain.Match;
import com.example.ddooheeJpa.domain.User.Model.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class GetMatchedUserRes {
    private long userGetMatched;
    private long userMatching;

    public GetMatchedUserRes(long userGetMatched, long userMatching){
        this.userGetMatched = userGetMatched;
        this.userMatching = userMatching;
    }

    public static GetMatchedUserRes of(User user) {
        return new GetMatchedUserRes(user.getUserId(), user.getUserId());
    }
}
