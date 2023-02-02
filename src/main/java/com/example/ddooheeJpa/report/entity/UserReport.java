package com.example.ddooheeJpa.report.entity;

import com.example.ddooheeJpa.common.domain.BaseEntity;
import com.example.ddooheeJpa.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "UserReport")
@Builder
@EntityListeners(AuditingEntityListener.class)
public class UserReport extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userReportIdx")
    private Long reportId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userReport")
    private User userReport;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userGetReported")
    private User userGetReported;

    private String userReportDetail;

    @Enumerated(EnumType.STRING)
    private UserReportStatus status;


}
