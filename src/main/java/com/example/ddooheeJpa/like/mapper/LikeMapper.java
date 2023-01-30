package com.example.ddooheeJpa.like.mapper;

import com.example.ddooheeJpa.like.dto.LikeDto;
import com.example.ddooheeJpa.like.entity.UserLikes;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LikeMapper {
    LikeMapper INSTANCE = Mappers.getMapper(LikeMapper.class);

    UserLikes dtoToEntity(LikeDto dto);

    LikeDto entityToDto(UserLikes entity);
}
