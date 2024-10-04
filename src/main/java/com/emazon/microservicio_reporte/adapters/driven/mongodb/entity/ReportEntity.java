package com.emazon.microservicio_reporte.adapters.driven.mongodb.entity;

import com.emazon.microservicio_reporte.domain.model.ProductReport;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "report")
public class ReportEntity {
    @Id
    private String reportId;

    private Long clientId;

    private String email;

    private Long totalQuantity;

    private BigDecimal totalPrice;

    private LocalDateTime date;

    private List<ProductReport> products;
}
