package com.example.ddooheeJpa.domain.Like;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LikeRepository extends JpaRepository<Like, Long> {

    @Query("select count(l.userGetLike) From Like l join User u on u.userId = l.userGetLike.userId " +
            "where l.userGetLike.userId = :user_id")
    Long getLikeCount(long user_id);
}
