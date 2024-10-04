package com.emazon.microservicio_reporte.adapters.driving.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
public class AddReportRequest {
    private Long clientId;
    private String email;
    private Long totalQuantity;
    private BigDecimal totalPrice;
    private LocalDateTime date;
    private List<ProductReportDto> products;
}
