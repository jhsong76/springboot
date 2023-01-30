package com.example.ddooheeJpa.report.converter;
import com.example.ddooheeJpa.report.dto.ReportRequestDto;
import com.example.ddooheeJpa.report.entity.UserReport;
import com.example.ddooheeJpa.report.entity.UserReportStatus;
import com.example.ddooheeJpa.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class ReportConverter {
    public UserReport Report(final User userReport, final User userGetReported, final ReportRequestDto reportRequestDto) {
        return UserReport.builder()
                .userReport(userReport)
                .userGetReported(userGetReported)
                .userReportDetail(reportRequestDto.getUserReportDetail())
                .status(UserReportStatus.ACTIVE)
                .build();
    }
}
