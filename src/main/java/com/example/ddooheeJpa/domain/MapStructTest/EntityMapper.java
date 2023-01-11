package com.example.ddooheeJpa.domain.MapStructTest;

public interface EntityMapper <D, E>{
    E toEntity(D dto);
    D toDto(E entity);
}
