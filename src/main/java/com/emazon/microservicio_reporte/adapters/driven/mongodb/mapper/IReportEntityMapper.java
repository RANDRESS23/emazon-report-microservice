package com.emazon.microservicio_reporte.adapters.driven.mongodb.mapper;

import com.emazon.microservicio_reporte.adapters.driven.mongodb.entity.ReportEntity;
import com.emazon.microservicio_reporte.domain.model.Report;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IReportEntityMapper {
    ReportEntity toEntity(Report report);
}
