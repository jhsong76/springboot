package com.example.ddooheeJpa.filter.repository;

import com.example.ddooheeJpa.filter.entity.UserMajorForFilter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserMajorForFilterRepository extends JpaRepository<UserMajorForFilter, Long> {

    @Query(value = "select mj from UserMajorForFilter mj where mj.user.userId = :userId")
    List<UserMajorForFilter> findAllByUser(@Param("userId") long userId);

    @Modifying
    @Transactional
    @Query(value = "delete from UserMajorForFilter jf where jf.user.userId = :userId")
    void deleteAllByUserId(@Param("userId") long userId);
}
