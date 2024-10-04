package com.emazon.microservicio_reporte.domain.api;

import com.emazon.microservicio_reporte.domain.model.Report;

public interface IReportServicePort {
    void saveReport(Report report);
}
