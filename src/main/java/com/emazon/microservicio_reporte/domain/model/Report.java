package com.emazon.microservicio_reporte.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Report {
    private final Long reportId;
    private Long clientId;
    private String email;
    private Long totalQuantity;
    private BigDecimal totalPrice;
    private LocalDateTime date;
    private List<ProductReport> products;

    public Report(Long reportId, Long clientId, String email, Long totalQuantity, BigDecimal totalPrice, LocalDateTime date, List<ProductReport> products) {
        this.reportId = reportId;
        this.clientId = clientId;
        this.email = email;
        this.totalQuantity = totalQuantity;
        this.totalPrice = totalPrice;
        this.date = date;
        this.products = products;
    }

    public Long getReportId() {
        return reportId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Long totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<ProductReport> getProducts() {
        return products;
    }

    public void setProducts(List<ProductReport> products) {
        this.products = products;
    }
}
