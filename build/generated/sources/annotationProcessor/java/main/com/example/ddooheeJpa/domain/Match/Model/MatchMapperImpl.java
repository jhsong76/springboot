package com.example.ddooheeJpa.domain.Match.Model;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-13T02:29:16+0900",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.15 (Oracle Corporation)"
)
@Component
public class MatchMapperImpl implements MatchMapper {

    @Override
    public Match toEntity(MatchDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Match match = new Match();

        match.setUserGetMatched( dto.getUserGetMatched() );
        match.setUserMatching( dto.getUserMatching() );
        match.setUserMatchStatus( dto.getUserMatchStatus() );
        match.setStatus( dto.getStatus() );

        return match;
    }

    @Override
    public MatchDTO toDto(Match entity) {
        if ( entity == null ) {
            return null;
        }

        MatchDTO matchDTO = new MatchDTO();

        matchDTO.setUserGetMatched( entity.getUserGetMatched() );
        matchDTO.setUserMatching( entity.getUserMatching() );
        matchDTO.setUserMatchStatus( entity.getUserMatchStatus() );
        matchDTO.setStatus( entity.getStatus() );

        return matchDTO;
    }
}
