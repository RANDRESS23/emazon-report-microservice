package com.emazon.microservicio_reporte.adapters.driving.controller;

import com.emazon.microservicio_reporte.adapters.driving.dto.request.AddReportRequest;
import com.emazon.microservicio_reporte.adapters.driving.dto.request.ProductReportDto;
import com.emazon.microservicio_reporte.adapters.driving.mapper.IReportRequestMapper;
import com.emazon.microservicio_reporte.domain.api.IReportServicePort;
import com.emazon.microservicio_reporte.domain.model.ProductReport;
import com.emazon.microservicio_reporte.domain.model.Report;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ReportRestControllerTest {
    @Mock
    private IReportRequestMapper reportRequestMapper;

    @Mock
    private IReportServicePort reportServicePort;

    @InjectMocks
    private ReportRestController reportRestController;

    @Test
    void addReport_shouldReturnCreatedStatus_whenValidRequest() {
        // Crear una solicitud válida
        AddReportRequest request = createValidAddReportRequest();

        // Crear un Report simulado
        Report report = createMockReport();

        // Simular el comportamiento del mapper usando ArgumentMatchers.any()
        when(reportRequestMapper.addRequestToReport(any(AddReportRequest.class))).thenReturn(report);

        // No necesitamos simular la respuesta del `saveReport` ya que es void
        doNothing().when(reportServicePort).saveReport(report);

        // Llamar al método bajo prueba
        ResponseEntity<HttpStatus> response = reportRestController.addReport(request);

        // Verificar las interacciones y las aserciones
        verify(reportRequestMapper, times(1)).addRequestToReport(any(AddReportRequest.class));
        verify(reportServicePort, times(1)).saveReport(report);

        // Verificar que no haya más interacciones inesperadas
        verifyNoMoreInteractions(reportRequestMapper, reportServicePort);

        // Verificar que el estado HTTP sea 201 CREATED
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    // Métodos auxiliares para crear objetos de prueba
    private AddReportRequest createValidAddReportRequest() {
        ProductReportDto product1 = new ProductReportDto(
            1L,
            "Product 1",
            2L,
            new BigDecimal("10.00"),
            new BigDecimal("20.00")
        );

        ProductReportDto product2 = new ProductReportDto(
            2L,
            "Product 2",
            3L,
            new BigDecimal("15.00"),
            new BigDecimal("45.00")
        );

        List<ProductReportDto> products = Arrays.asList(product1, product2);

        return new AddReportRequest(
            123L,
            "test@example.com",
            5L,
            new BigDecimal("65.00"),
            LocalDateTime.now(),
            products
        );
    }

    private Report createMockReport() {
        List<ProductReport> products = Arrays.asList(
                new ProductReport(1L, "Product 1", 2L, new BigDecimal("10.00"), new BigDecimal("20.00")),
                new ProductReport(2L, "Product 2", 3L, new BigDecimal("15.00"), new BigDecimal("45.00"))
        );

        return new Report(1L, 123L, "test@example.com", 5L, new BigDecimal("65.00"), LocalDateTime.now(), products);
    }
}