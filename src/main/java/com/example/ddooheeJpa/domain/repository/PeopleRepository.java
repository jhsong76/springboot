package com.example.ddooheeJpa.domain.repository;

import com.example.ddooheeJpa.domain.MapStructTest.People;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {
}
