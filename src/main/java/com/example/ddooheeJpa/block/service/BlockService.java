package com.example.ddooheeJpa.block.service;

import com.example.ddooheeJpa.block.converter.BlockConverter;
import com.example.ddooheeJpa.block.dto.BlockDto;
import com.example.ddooheeJpa.block.entity.UserBlock;
import com.example.ddooheeJpa.block.mapper.BlockMapper;
import com.example.ddooheeJpa.block.repository.BlockRepository;
import com.example.ddooheeJpa.user.entity.User;
import com.example.ddooheeJpa.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BlockService {

    private final UserRepository userRepository;
    private final BlockRepository blockRepository;
    private final BlockConverter blockconverter;
    // 유저 차단
    @Transactional
    public BlockDto userBlock(long userGiveBlock, long userGetBlocked) {
        User Give = userRepository.findById(userGiveBlock)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다."));
        User Get = userRepository.findById(userGetBlocked)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다."));

        UserBlock entity = blockRepository.save(blockconverter.block(Give, Get));
        BlockDto dto = BlockMapper.INSTANCE.entityToDto(entity);

        return dto;
    }
}
