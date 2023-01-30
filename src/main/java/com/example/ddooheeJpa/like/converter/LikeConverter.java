package com.example.ddooheeJpa.like.converter;

import com.example.ddooheeJpa.like.entity.UserLikes;
import com.example.ddooheeJpa.like.entity.UserLikesStatus;
import com.example.ddooheeJpa.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class LikeConverter {
    public UserLikes UserLike(final User give, final User get) {
        return UserLikes.builder()
                .userGiveLikes(give)
                .userGetLikes(get)
                .status(UserLikesStatus.ACTIVE)
                .build();
    }
}
