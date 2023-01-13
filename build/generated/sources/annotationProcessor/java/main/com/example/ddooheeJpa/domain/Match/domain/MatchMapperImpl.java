package com.example.ddooheeJpa.domain.Match.domain;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
<<<<<<< HEAD:build/generated/sources/annotationProcessor/java/main/com/example/ddooheeJpa/domain/Match/domain/MatchMapperImpl.java
    date = "2023-01-13T13:13:24+0900",
=======
    date = "2023-01-13T02:29:16+0900",
>>>>>>> 5e97e70cff396b419cf5a09637b4cc09d60b4761:build/generated/sources/annotationProcessor/java/main/com/example/ddooheeJpa/domain/Match/Model/MatchMapperImpl.java
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
