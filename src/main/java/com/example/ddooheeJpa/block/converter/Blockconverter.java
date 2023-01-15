package com.example.ddooheeJpa.block.converter;


import com.example.ddooheeJpa.block.entity.Block;
import com.example.ddooheeJpa.block.entity.userBlockStatus;
import com.example.ddooheeJpa.user.entity.User;
import com.example.ddooheeJpa.match.dto.MatchNoResDto;
import org.springframework.stereotype.Component;

@Component
public class Blockconverter {

    public Block ReqMatchNoDto(User userGetMatched, User userMatcing) {
        return Block.builder()
                .userGiveBlock(userGetMatched)
                .userGetBlocked(userMatcing)
                .status(userBlockStatus.ACTIVE)
                .build();
    }

    public MatchNoResDto ResMatchNoDto(Block block){
        return MatchNoResDto.builder()
                .id(block.getId())
                .build();
    }

    public Block ReqMatchdeleteDto(User userMatching, User userGetMatched) {
        return Block.builder()
                .userGiveBlock(userMatching)
                .userGetBlocked(userGetMatched)
                .status(userBlockStatus.ACTIVE)
                .build();
    }
}
