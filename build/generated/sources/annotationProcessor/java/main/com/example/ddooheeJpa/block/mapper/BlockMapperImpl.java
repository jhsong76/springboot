package com.example.ddooheeJpa.block.mapper;

import com.example.ddooheeJpa.block.dto.BlockDto;
import com.example.ddooheeJpa.block.dto.BlockDto.BlockDtoBuilder;
import com.example.ddooheeJpa.block.entity.UserBlock;
import com.example.ddooheeJpa.block.entity.UserBlock.UserBlockBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-02T00:15:24+0900",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.15 (Oracle Corporation)"
)
@Component
public class BlockMapperImpl implements BlockMapper {

    @Override
    public UserBlock dtoToEntity(BlockDto dto) {
        if ( dto == null ) {
            return null;
        }

        UserBlockBuilder<?, ?> userBlock = UserBlock.builder();

        userBlock.id( dto.getId() );

        return userBlock.build();
    }

    @Override
    public BlockDto entityToDto(UserBlock entity) {
        if ( entity == null ) {
            return null;
        }

        BlockDtoBuilder blockDto = BlockDto.builder();

        if ( entity.getId() != null ) {
            blockDto.id( entity.getId() );
        }

        return blockDto.build();
    }
}
