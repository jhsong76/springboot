package com.example.ddooheeJpa.domain.Match;


import com.example.ddooheeJpa.domain.Match.Model.Dto.get.getMatchListRes;
import com.example.ddooheeJpa.domain.Match.Model.Match;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;


@Repository

public interface MatchRepository extends JpaRepository<Match, Long>  {


}
