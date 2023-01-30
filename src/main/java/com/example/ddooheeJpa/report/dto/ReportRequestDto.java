package com.example.ddooheeJpa.report.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReportRequestDto {
    private String userReportDetail;

    public String getUserReportDetail() {
        return userReportDetail;
    }
}
