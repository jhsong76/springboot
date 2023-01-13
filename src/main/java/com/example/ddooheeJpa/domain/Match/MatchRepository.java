package com.example.ddooheeJpa.domain.Match;


import com.example.ddooheeJpa.domain.Match.domain.Match;
import com.example.ddooheeJpa.domain.User.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;


@Repository

public interface MatchRepository extends JpaRepository<Match, Long>  {

    @Query("select m from Match m where m.userGetMatched.userId = :user_id")
    List<Match> findUserGetMatchingByUserId(Long user_id);


    //List<UserMatchMapping> findAllById(Long user_id);
    @Query(
            nativeQuery = true,
            value = "select u.user_nick_name, u.user_id" +
                    "from user u " +
                    "join user_match m on u.user_id = m.userGetMatched" +
                    "where m.userGetMatched = :user_id"
    ) List<Match> findUserGetMatchedByUserId2(@PathVariable("user_id") Long user_id);

    //@Query(value = "select m.id from Match m where m.userGetMatched.userId = :userGetMatched and m.userMatching.userId = :userMatching")
    Optional<Match> findIdByUserGetMatchedAndUserMatching(@PathVariable("userGetMatched") User userGetMatched, @PathVariable("userMatching") Long userMatching);

}
