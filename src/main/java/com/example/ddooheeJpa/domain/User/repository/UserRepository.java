package com.example.ddooheeJpa.domain.User.repository;

import com.example.ddooheeJpa.match.entity.Match;
import com.example.ddooheeJpa.domain.User.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //@Query(value = "select u from User u where u.userId = :userGetMatched")
    //List<UserMatchMapping> findAllByUserId(@Param("userGetMatched") Long user_id);
    @Query(value = "select u.userNickName, u.userMajorName, u.userProfileImg from User u where u.userId = :userGetMatched")
    List<Match> findMatchByuserId(@Param("userGetMatched") Optional<Match> userGetMatched);

    //@Query(value = "select u.userNickName, u.userMajorName, u.userProfileImg from User u where u.userId = :userMatching")
    // List<Match> findMatchingByuserId(@Param("userId")Long userId);

   // Optional<User> findByUserMatching

}