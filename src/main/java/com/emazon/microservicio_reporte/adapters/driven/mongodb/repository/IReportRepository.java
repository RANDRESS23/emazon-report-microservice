package com.emazon.microservicio_reporte.adapters.driven.mongodb.repository;

import com.emazon.microservicio_reporte.adapters.driven.mongodb.entity.ReportEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IReportRepository extends MongoRepository<ReportEntity, String> {
}
