package com.example.ddooheeJpa.domain.Match.domain;

import com.example.ddooheeJpa.domain.MapStructTest.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MatchMapper extends EntityMapper<MatchDTO, Match> {
}
