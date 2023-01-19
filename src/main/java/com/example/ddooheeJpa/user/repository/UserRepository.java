package com.example.ddooheeJpa.user.repository;


import com.example.ddooheeJpa.match.dto.UserMatchList;
import com.example.ddooheeJpa.match.entity.Match;
import com.example.ddooheeJpa.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select u from User u join Match m on m.userMatching.userId = u.userId " +
            "where m.userGetMatched.userId = :userGetMatched")
    List<UserMatchList> getUsersByUserId(@Param("userGetMatched") Long userGetMatched);



}
