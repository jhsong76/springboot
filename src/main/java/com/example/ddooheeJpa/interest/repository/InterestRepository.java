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
    @Query(value = "select group_concat(i.interest), i.user_id from user_interest i join user_match m on m.user_matching = i.user_id\n" +
            "where m.user_get_matched = ? GROUP BY m.user_matching", nativeQuery = true)
    List<String> getUserInterestsByUser(@Param("user_get_matched") Long id);
}
