package com.example.ddooheeJpa.filter.repository;

import com.example.ddooheeJpa.filter.entity.UserGradeForFilter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserGradeForFilterRepository extends JpaRepository<UserGradeForFilter, Long> {

    @Query(value = "select g from UserGradeForFilter g where g.user.userId = :userId")
    List<UserGradeForFilter> findAllByUser(@Param("userId") long userId);

    @Modifying
    @Transactional
    @Query(value = "delete from UserGradeForFilter gf where gf.user.userId = :userId")
    void deleteAllByUserId(@Param("userId") long userId);
}
