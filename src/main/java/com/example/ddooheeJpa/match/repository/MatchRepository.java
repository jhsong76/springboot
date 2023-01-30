package com.example.ddooheeJpa.match.repository;

import com.example.ddooheeJpa.match.entity.UserMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<UserMatch, Long> {
    @Modifying
    @Query("update UserMatch m set m.userMatchStatus = 'ACTIVE' where m.userGetMatched.userId = :userGetMatched and m.status = 'ACTIVE'")
    int updateUserByUserGetMatched(@Param("userGetMatched") Long userGetMatched);
}
