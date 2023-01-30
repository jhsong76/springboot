package com.example.ddooheeJpa.report.mapper;

import com.example.ddooheeJpa.report.dto.ReportDto;
import com.example.ddooheeJpa.report.entity.UserReport;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ReportMapper {
    ReportMapper INSTANCE = Mappers.getMapper(ReportMapper.class);

    UserReport dtoToEntity(ReportDto dto);

    ReportDto entityToDto(UserReport entity);

}
