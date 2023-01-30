package com.example.ddooheeJpa.block.mapper;

import com.example.ddooheeJpa.block.dto.BlockDto;
import com.example.ddooheeJpa.block.entity.UserBlock;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BlockMapper {
    BlockMapper INSTANCE = Mappers.getMapper(BlockMapper.class);

    UserBlock dtoToEntity(BlockDto dto);

    BlockDto entityToDto(UserBlock entity);
}
