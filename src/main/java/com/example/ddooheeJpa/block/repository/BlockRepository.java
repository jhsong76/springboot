package com.example.ddooheeJpa.block.repository;

import com.example.ddooheeJpa.block.entity.UserBlock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockRepository extends JpaRepository<UserBlock, Long> {
}
