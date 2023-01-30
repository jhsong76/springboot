package com.example.ddooheeJpa.match.repository;

import com.example.ddooheeJpa.match.entity.UserMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<UserMatch, Long> {
}
