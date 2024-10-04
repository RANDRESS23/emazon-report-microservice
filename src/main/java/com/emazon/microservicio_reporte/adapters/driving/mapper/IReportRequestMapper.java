package com.emazon.microservicio_reporte.adapters.driving.mapper;

import com.emazon.microservicio_reporte.adapters.driving.dto.request.AddReportRequest;
import com.emazon.microservicio_reporte.adapters.driving.dto.request.ProductReportDto;
import com.emazon.microservicio_reporte.domain.model.ProductReport;
import com.emazon.microservicio_reporte.domain.model.Report;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IReportRequestMapper {
    ProductReport toProductReport(ProductReportDto productReportDto);

    default Report addRequestToReport(AddReportRequest addReportRequest) {
        List<ProductReport> listOfProductsReport = addReportRequest.getProducts().stream()
                .map(this::toProductReport)
                .toList();

        return new Report(
                null,
                addReportRequest.getClientId(),
                addReportRequest.getEmail(),
                addReportRequest.getTotalQuantity(),
                addReportRequest.getTotalPrice(),
                addReportRequest.getDate(),
                listOfProductsReport
        );
    }
}
