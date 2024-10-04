package com.emazon.microservicio_reporte.domain.api.usecase;

import com.emazon.microservicio_reporte.domain.model.ProductReport;
import com.emazon.microservicio_reporte.domain.model.Report;
import com.emazon.microservicio_reporte.domain.spi.IReportPersistencePort;
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
class ReportUseCaseTest {
    @Mock
    private IReportPersistencePort reportPersistencePort;

    @InjectMocks
    private ReportUseCase reportUseCase;

    @Test
    void saveReport_shouldDelegateToPersistencePort() {
        // Crear un Report simulado
        Report report = createMockReport();

        // Llamar al método bajo prueba
        reportUseCase.saveReport(report);

        // Verificar que el puerto de persistencia fue llamado correctamente con el Report
        verify(reportPersistencePort, times(1)).saveReport(report);

        // Verificar que no haya más interacciones inesperadas
        verifyNoMoreInteractions(reportPersistencePort);
    }

    // Método auxiliar para crear un objeto de Report simulado
    private Report createMockReport() {
        List<ProductReport> products = Arrays.asList(
                new ProductReport(1L, "Product 1", 2L, new BigDecimal("10.00"), new BigDecimal("20.00")),
                new ProductReport(2L, "Product 2", 3L, new BigDecimal("15.00"), new BigDecimal("45.00"))
        );

        return new Report(1L, 123L, "test@example.com", 5L, new BigDecimal("65.00"), LocalDateTime.now(), products);
    }
}