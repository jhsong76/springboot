package com.example.ddooheeJpa.block.repository;

import com.example.ddooheeJpa.block.entity.UserBlock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BlockRepository extends JpaRepository<UserBlock, Long> {
    @Modifying
    @Query(value = "update UserBlock b set b.blockStatus = 'INACTIVE' where b.blockId = :blockId")
    Integer updateStatus(@Param("blockId")Long blockId);
}
