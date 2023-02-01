package com.example.ddooheeJpa.match.mapper;

import com.example.ddooheeJpa.match.dto.MatchDto;
import com.example.ddooheeJpa.match.dto.MatchDto.MatchDtoBuilder;
import com.example.ddooheeJpa.match.entity.UserMatch;
import com.example.ddooheeJpa.match.entity.UserMatch.UserMatchBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-02T00:15:24+0900",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.15 (Oracle Corporation)"
)
@Component
public class MatchMapperImpl implements MatchMapper {

    @Override
    public UserMatch dtoToEntity(MatchDto dto) {
        if ( dto == null ) {
            return null;
        }

        UserMatchBuilder userMatch = UserMatch.builder();

        userMatch.id( dto.getId() );

        return userMatch.build();
    }

    @Override
    public MatchDto entityToDto(UserMatch entity) {
        if ( entity == null ) {
            return null;
        }

        MatchDtoBuilder matchDto = MatchDto.builder();

        if ( entity.getId() != null ) {
            matchDto.id( entity.getId() );
        }

        return matchDto.build();
    }
}
