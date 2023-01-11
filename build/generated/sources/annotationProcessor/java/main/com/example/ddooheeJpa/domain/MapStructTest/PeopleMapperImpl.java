package com.example.ddooheeJpa.domain.MapStructTest;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-11T23:59:00+0900",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.15 (Oracle Corporation)"
)
@Component
public class PeopleMapperImpl implements PeopleMapper {

    @Override
    public People toEntity(PeopleDTO dto) {
        if ( dto == null ) {
            return null;
        }

        People people = new People();

        people.setId( dto.getId() );
        people.setName( dto.getName() );
        people.setAge( dto.getAge() );

        return people;
    }

    @Override
    public PeopleDTO toDto(People entity) {
        if ( entity == null ) {
            return null;
        }

        PeopleDTO peopleDTO = new PeopleDTO();

        peopleDTO.setId( entity.getId() );
        peopleDTO.setName( entity.getName() );
        peopleDTO.setAge( entity.getAge() );

        return peopleDTO;
    }
}
