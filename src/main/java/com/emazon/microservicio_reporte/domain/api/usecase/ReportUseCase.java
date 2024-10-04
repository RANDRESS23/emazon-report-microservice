package com.emazon.microservicio_reporte.domain.api.usecase;

import com.emazon.microservicio_reporte.domain.api.IReportServicePort;
import com.emazon.microservicio_reporte.domain.model.Report;
import com.emazon.microservicio_reporte.domain.spi.IReportPersistencePort;

public class ReportUseCase implements IReportServicePort {
    private final IReportPersistencePort reportPersistencePort;

    public ReportUseCase(IReportPersistencePort reportPersistencePort) {
        this.reportPersistencePort = reportPersistencePort;
    }

    @Override
    public void saveReport(Report report) {
        reportPersistencePort.saveReport(report);
    }
}
