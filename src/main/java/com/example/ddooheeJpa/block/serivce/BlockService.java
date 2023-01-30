package com.example.ddooheeJpa.block.serivce;

import com.example.ddooheeJpa.block.converter.Blockconverter;
import com.example.ddooheeJpa.block.dto.BlockDto;
import com.example.ddooheeJpa.block.entity.UserBlock;
import com.example.ddooheeJpa.block.mapper.BlockMapper;
import com.example.ddooheeJpa.block.repository.BlockRepository;
import com.example.ddooheeJpa.common.exception.LInkyBussinessException;
import com.example.ddooheeJpa.user.dto.UserListDto;
import com.example.ddooheeJpa.user.entity.User;
import com.example.ddooheeJpa.user.mapper.UserMapper;
import com.example.ddooheeJpa.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BlockService {

    private final UserRepository userRepository;
    private final BlockRepository blockRepository;
    private final Blockconverter blockconverter;

    // 유저 차단
    @Transactional
    public BlockDto userBlock(long userGiveBlock, long userGetBlocked) {
        User Give = userRepository.findById(userGiveBlock)
                .orElseThrow(() -> new LInkyBussinessException("해당 유저가 존재하지 않습니다.", HttpStatus.BAD_REQUEST));
        User Get = userRepository.findById(userGetBlocked)
                .orElseThrow(() -> new LInkyBussinessException("해당 유저가 존재하지 않습니다.", HttpStatus.BAD_REQUEST));

        UserBlock entity = blockRepository.save(blockconverter.block(Give, Get));
        BlockDto dto = BlockMapper.INSTANCE.entityToDto(entity);

        return dto;
    }

    // 차단 리스트 조회
    public List<UserListDto> BlockList(Long userGiveBlock) {
        List<User> users = userRepository.findAllByUserGiveBlock(userGiveBlock);
        List<UserListDto> dto = UserMapper.INSTANCE.entityToDtoList(users);
        return dto;
    }
}
