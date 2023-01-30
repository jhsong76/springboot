package com.example.ddooheeJpa.like.repository;

import com.example.ddooheeJpa.like.entity.UserLikes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<UserLikes, Long> {

}
