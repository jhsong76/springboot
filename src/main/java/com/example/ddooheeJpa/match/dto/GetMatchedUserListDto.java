package com.example.ddooheeJpa.match.dto;

import com.example.ddooheeJpa.user.entity.User;
import com.example.ddooheeJpa.user.entity.UserInterest;
import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
public class GetMatchedUserListDto {
    private List<UserInterest>  userInterests;
    //private List<Long> userLikes;
}
