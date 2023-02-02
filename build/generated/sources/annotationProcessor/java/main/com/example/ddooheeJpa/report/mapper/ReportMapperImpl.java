package com.example.ddooheeJpa.report.mapper;

import com.example.ddooheeJpa.report.dto.ReportDto;
import com.example.ddooheeJpa.report.dto.ReportDto.ReportDtoBuilder;
import com.example.ddooheeJpa.report.entity.UserReport;
import com.example.ddooheeJpa.report.entity.UserReport.UserReportBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-02T02:43:54+0900",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.15 (Oracle Corporation)"
)
@Component
public class ReportMapperImpl implements ReportMapper {

    @Override
    public UserReport dtoToEntity(ReportDto dto) {
        if ( dto == null ) {
            return null;
        }

        UserReportBuilder userReport = UserReport.builder();

        userReport.reportId( dto.getReportId() );

        return userReport.build();
    }

    @Override
    public ReportDto entityToDto(UserReport entity) {
        if ( entity == null ) {
            return null;
        }

        ReportDtoBuilder reportDto = ReportDto.builder();

        if ( entity.getReportId() != null ) {
            reportDto.reportId( entity.getReportId() );
        }

        return reportDto.build();
    }
}
