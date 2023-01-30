package com.example.ddooheeJpa.report.service;

import com.example.ddooheeJpa.common.exception.LInkyBussinessException;
import com.example.ddooheeJpa.report.converter.ReportConverter;
import com.example.ddooheeJpa.report.dto.ReportDto;
import com.example.ddooheeJpa.report.dto.ReportRequestDto;
import com.example.ddooheeJpa.report.entity.UserReport;
import com.example.ddooheeJpa.report.mapper.ReportMapper;
import com.example.ddooheeJpa.report.repository.ReportRepository;
import com.example.ddooheeJpa.user.entity.User;
import com.example.ddooheeJpa.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReportService {

    private final UserRepository userRepository;
    private final ReportRepository reportRepository;
    private final ReportConverter reportConverter;

    // 유저 신고 등록
    @Transactional
    public ReportDto userReport(long userReport, long userGetReported, ReportRequestDto reportRequestDto) {
        User Report = userRepository.findById(userReport)
                .orElseThrow(() -> new LInkyBussinessException("해당 유저가 존재하지 않습니다. ", HttpStatus.BAD_REQUEST));
        User GetReported = userRepository.findById(userGetReported)
                .orElseThrow(() -> new LInkyBussinessException("해당 유저가 존재하지 않습니다. ", HttpStatus.BAD_REQUEST));

        if (reportRequestDto.getUserReportDetail().isEmpty()) {
            throw new LInkyBussinessException("신고 사유를 작성해주세요. ", HttpStatus.BAD_REQUEST);
        }

        UserReport entity = reportRepository.save(reportConverter.Report(Report, GetReported, reportRequestDto));
        ReportDto reportDto = ReportMapper.INSTANCE.entityToDto(entity);

        return reportDto;
    }
}
