package com.example.ddooheeJpa.filter.repository;

import com.example.ddooheeJpa.filter.entity.UserMbtiForFilter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserMbtiForFilterRepository extends JpaRepository<UserMbtiForFilter, Long> {

    @Query(value = "select m from UserMbtiForFilter m where m.user.userId = :userId")
    List<UserMbtiForFilter> findAllByUser(@Param("userId") long userId);

    @Modifying
    @Transactional
    @Query(value = "delete from UserMbtiForFilter mf where mf.user.userId = :userId")
    void deleteAllByUserId(@Param("userId") long userId);
}
