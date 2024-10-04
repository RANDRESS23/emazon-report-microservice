package com.emazon.microservicio_reporte.configuration;

import com.emazon.microservicio_reporte.adapters.driven.mongodb.adapter.ReportAdapter;
import com.emazon.microservicio_reporte.adapters.driven.mongodb.mapper.IReportEntityMapper;
import com.emazon.microservicio_reporte.adapters.driven.mongodb.repository.IReportRepository;
import com.emazon.microservicio_reporte.domain.api.IReportServicePort;
import com.emazon.microservicio_reporte.domain.api.usecase.ReportUseCase;
import com.emazon.microservicio_reporte.domain.spi.IReportPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IReportRepository reportRepository;
    private final IReportEntityMapper reportEntityMapper;

    @Bean
    public IReportPersistencePort reportPersistencePort() {
        return new ReportAdapter(reportRepository, reportEntityMapper);
    }

    @Bean
    public IReportServicePort reportServicePort() {
        return new ReportUseCase(reportPersistencePort());
    }
}
