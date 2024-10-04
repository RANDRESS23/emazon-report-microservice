package com.emazon.microservicio_reporte.adapters.driven.mongodb.adapter;

import com.emazon.microservicio_reporte.adapters.driven.mongodb.entity.ReportEntity;
import com.emazon.microservicio_reporte.adapters.driven.mongodb.mapper.IReportEntityMapper;
import com.emazon.microservicio_reporte.adapters.driven.mongodb.repository.IReportRepository;
import com.emazon.microservicio_reporte.domain.model.ProductReport;
import com.emazon.microservicio_reporte.domain.model.Report;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ReportAdapterTest {
    @Mock
    private IReportRepository reportRepository;

    @Mock
    private IReportEntityMapper reportEntityMapper;

    @InjectMocks
    private ReportAdapter reportAdapter;

    @Test
    void saveReport_shouldConvertToEntityAndSave() {
        // Crear un Report simulado
        Report report = createMockReport();

        // Crear un ReportEntity simulado
        ReportEntity reportEntity = createMockReportEntity();

        // Simular el comportamiento del mapper
        when(reportEntityMapper.toEntity(report)).thenReturn(reportEntity);

        // Simular el comportamiento del repository
        when(reportRepository.save(reportEntity)).thenReturn(reportEntity);

        // Llamar al método bajo prueba
        reportAdapter.saveReport(report);

        // Verificar que el mapper fue llamado para convertir el Report a ReportEntity
        verify(reportEntityMapper, times(1)).toEntity(report);

        // Verificar que el repository fue llamado para guardar la entidad
        verify(reportRepository, times(1)).save(reportEntity);

        // Verificar que no haya más interacciones inesperadas
        verifyNoMoreInteractions(reportEntityMapper, reportRepository);
    }

    // Métodos auxiliares para crear objetos de prueba
    private Report createMockReport() {
        List<ProductReport> products = Arrays.asList(
                new ProductReport(1L, "Product 1", 2L, new BigDecimal("10.00"), new BigDecimal("20.00")),
                new ProductReport(2L, "Product 2", 3L, new BigDecimal("15.00"), new BigDecimal("45.00"))
        );

        return new Report(1L, 123L, "test@example.com", 5L, new BigDecimal("65.00"), LocalDateTime.now(), products);
    }

    private ReportEntity createMockReportEntity() {
        List<ProductReport> products = Arrays.asList(
                new ProductReport(1L, "Product 1", 2L, new BigDecimal("10.00"), new BigDecimal("20.00")),
                new ProductReport(2L, "Product 2", 3L, new BigDecimal("15.00"), new BigDecimal("45.00"))
        );

        return new ReportEntity("1", 123L, "test@example.com", 5L, new BigDecimal("65.00"), LocalDateTime.now(), products);
    }
}