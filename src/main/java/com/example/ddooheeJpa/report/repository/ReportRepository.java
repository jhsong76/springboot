package com.example.ddooheeJpa.report.repository;

import com.example.ddooheeJpa.report.entity.UserReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<UserReport, Long> {
}
