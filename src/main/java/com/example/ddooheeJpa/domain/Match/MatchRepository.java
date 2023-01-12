package com.example.ddooheeJpa.domain.Match;


import com.example.ddooheeJpa.domain.Match.Model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
}
