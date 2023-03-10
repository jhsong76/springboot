package com.example.ddooheeJpa.block.converter;


import com.example.ddooheeJpa.block.entity.UserBlock;
import com.example.ddooheeJpa.block.entity.userBlockStatus;
import com.example.ddooheeJpa.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class Blockconverter {

    public UserBlock block(User userGetMatched, User userMatcing) {
        return UserBlock.builder()
                .userGiveBlock(userGetMatched)
                .userGetBlocked(userMatcing)
                .blockStatus(userBlockStatus.ACTIVE)
                .build();
    }

    public UserBlock blockGetMatched(User userMatching, User userGetMatched) {
        return UserBlock.builder()
                .userGiveBlock(userMatching)
                .userGetBlocked(userGetMatched)
                .blockStatus(userBlockStatus.ACTIVE)
                .build();
    }
}
