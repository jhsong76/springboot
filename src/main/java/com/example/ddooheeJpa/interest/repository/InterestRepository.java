package com.example.ddooheeJpa.interest.repository;

import com.example.ddooheeJpa.match.entity.Match;
import com.example.ddooheeJpa.user.entity.User;
import com.example.ddooheeJpa.user.entity.UserInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InterestRepository extends JpaRepository<UserInterest, Long> {
    //@Query("select i.Interest from UserInterest i where i.user = :userGetMatched")
    @Query(value = "select i.Interest from UserInterest i join Match m on m.userMatching.userId = i.user.userId " +
            "where m.userGetMatched.userId = :userGetMatched")
    List<String> getUserInterestsByUser(@Param("userGetMatched") Long userGetMatched);
}
