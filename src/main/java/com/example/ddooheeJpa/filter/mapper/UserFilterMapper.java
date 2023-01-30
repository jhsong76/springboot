package com.example.ddooheeJpa.filter.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserFilterMapper {
    UserFilterMapper INSTANCE = Mappers.getMapper(UserFilterMapper.class);


   // UserGenderForFilter dtoToEntity(UserFilterDto dto);

   // UserFilterDto entityToDto(UserGenderForFilter entity);
}
