package com.example.ddooheeJpa.service;

import com.example.ddooheeJpa.domain.MapStructTest.People;
import com.example.ddooheeJpa.domain.MapStructTest.PeopleDTO;
import com.example.ddooheeJpa.domain.MapStructTest.PeopleMapper;
import com.example.ddooheeJpa.domain.repository.PeopleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PeopleService {

    private final PeopleRepository peopleRepository;
    private final PeopleMapper peopleMapper;

    @Transactional
    public People save(PeopleDTO peopleDTO) {
        People people = peopleMapper.toEntity(peopleDTO); // DTO -> Entity
        peopleRepository.save(people); // Entity를 저장

        return people;
    }

    public List<People> getPeoples() {
        return peopleRepository.findAll();
    }
}
