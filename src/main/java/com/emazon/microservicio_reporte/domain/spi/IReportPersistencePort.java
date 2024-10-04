package com.emazon.microservicio_reporte.domain.spi;

import com.emazon.microservicio_reporte.domain.model.Report;

public interface IReportPersistencePort {
    void saveReport(Report report);
}
