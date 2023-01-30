package com.example.ddooheeJpa.block.converter;

import com.example.ddooheeJpa.block.entity.UserBlock;
import com.example.ddooheeJpa.block.entity.userBlockStatus;
import org.springframework.stereotype.Component;

@Component
public class BlockConverter {
    public UserBlock block(User userGetMatched, User userMatcing) {
        return UserBlock.builder()
                .userGiveBlock(userGetMatched)
                .userGetBlocked(userMatcing)
                .status(userBlockStatus.ACTIVE)
                .build();
    }
}
