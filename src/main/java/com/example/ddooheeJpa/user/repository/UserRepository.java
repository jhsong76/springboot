package com.example.ddooheeJpa.user.repository;

import com.example.ddooheeJpa.match.dto.GetMatchedUserListDto;
import com.example.ddooheeJpa.match.dto.UserMatchList;
import com.example.ddooheeJpa.match.entity.Match;
import com.example.ddooheeJpa.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    @Query(value = "select u.userNickName, u.userMajorName, u.userProfileImg from User u where u.userId = :userGetMatched")
    List<Match> findMatchByuserId(@Param("userGetMatched") Optional<Match> userGetMatched);


    @Query(value = "select u from User u join Match m on m.userMatching.userId = u.userId " +
            "where m.userGetMatched.userId = :userGetMatched")
    List<UserMatchList> getUsersByUserId(@Param("userGetMatched") Long userGetMatched);


    @Query("select u from User u where u.gradStatus = false")
    List<User> findAllByGradStatusTrue();


}
