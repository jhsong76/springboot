package com.example.ddooheeJpa.domain.MapStructTest;

import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

public interface EntityMapper <D, E>{
    E toEntity(D dto);
    D toDto(E entity);


}
