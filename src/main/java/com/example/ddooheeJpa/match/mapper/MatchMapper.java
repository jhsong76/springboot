package com.example.ddooheeJpa.match.mapper;

import com.example.ddooheeJpa.match.dto.MatchDto;
import com.example.ddooheeJpa.match.entity.UserMatch;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MatchMapper {
    MatchMapper INSTANCE = Mappers.getMapper(MatchMapper.class);

    UserMatch dtoToEntity(MatchDto dto);

    MatchDto entityToDto(UserMatch entity);

}
