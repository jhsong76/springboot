package com.example.ddooheeJpa.like.repository;

import com.example.ddooheeJpa.user.entity.User;
import com.example.ddooheeJpa.user.entity.UserLikes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikesRepository extends JpaRepository <UserLikes, Long> {


    @Query(value = "select count(s.id) from UserLikes s join Match m on m.userMatching.userId = s.userGetLikes.userId " +
            "where m.userGetMatched.userId = :userGetMatched GROUP BY s.userGetLikes")
    List<Long> countByUserGetLikes(@Param("userGetMatched") Long userGetMatched);
}
