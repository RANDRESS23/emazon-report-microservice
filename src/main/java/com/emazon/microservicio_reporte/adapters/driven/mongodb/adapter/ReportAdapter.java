package com.emazon.microservicio_reporte.adapters.driven.mongodb.adapter;

import com.emazon.microservicio_reporte.adapters.driven.mongodb.mapper.IReportEntityMapper;
import com.emazon.microservicio_reporte.adapters.driven.mongodb.repository.IReportRepository;
import com.emazon.microservicio_reporte.domain.model.Report;
import com.emazon.microservicio_reporte.domain.spi.IReportPersistencePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ReportAdapter implements IReportPersistencePort {
    private final IReportRepository reportRepository;
    private final IReportEntityMapper reportEntityMapper;

    @Override
    public void saveReport(Report report) {
        reportRepository.save(reportEntityMapper.toEntity(report));
    }
}
