package com.example.ddooheeJpa.user.repository;

import com.example.ddooheeJpa.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT u FROM User u JOIN UserMatch m ON m.userMatching.userId = u.userId " +
            "WHERE m.userGetMatched.userId = :userGetMatched AND m.status = 'ACTIVE' AND m.userMatchStatus = 'INACTIVE'")
    List<User> findAllByUserGetMatched(@Param("userGetMatched") Long userGetMatched);

    @Query(value = "SELECT u FROM User u JOIN UserMatch m ON m.userGetMatched.userId = u.userId " +
            "WHERE m.userMatching.userId = :userMatching AND m.status = 'ACTIVE' AND m.userMatchStatus = 'INACTIVE'")
    List<User> findAllByUserMatching(@Param("userMatching") long userMatching);
}
