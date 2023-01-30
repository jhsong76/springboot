package com.example.ddooheeJpa.filter.repository;

import com.example.ddooheeJpa.filter.entity.UserGenderForFilter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserGenderForFilterRepository extends JpaRepository <UserGenderForFilter, Long> {

    @Query(value = "select f from UserGenderForFilter f where f.user.userId = :userId")
    UserGenderForFilter findAllByUserId(@Param("userId")Long userId);

    @Query(value = "select f from UserGenderForFilter f where f.user.userId = :userId")
    List<UserGenderForFilter> findAllByUser(@Param("userId") long userId);

    @Modifying
    @Transactional
    @Query(value = "delete from UserGenderForFilter f where f.user.userId = :userId")
    void deleteAllByUserId(@Param("userId") long userId);
}
