package com.example.ddooheeJpa.domain.MapStructTest;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PeopleMapper extends EntityMapper<PeopleDTO, People>{
}
