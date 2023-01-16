package com.example.ddooheeJpa.match.repository;

import com.example.ddooheeJpa.match.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
    @Modifying
    @Query("update Match m set m.userMatchStatus = 'ACTIVE' where m.userGetMatched.userId = :userGetMatched")
    int updateMatchStatusByUserGetMatched(@Param("userGetMatched") Long userGetMatched);


    @Query("select m from Match m where m.userGetMatched.userId = :userGetMatched")
    List<Match> findUserMatchByUserGetMatched(@Param("userGetMatched")Long userGetMatched);

    @Query("select m.userMatching from Match m where m.userGetMatched.userId = :userGetMatched")
    List<Object[]> find(@Param("userGetMatched") Long userGetMatched);
    @Query("select userMatching.userId from Match where userGetMatched.userId = :userGetMatched")
    List<Match> findUserMatchingByUserGetMatched(@Param("userGetMatched")Long userGetMatched);
}
