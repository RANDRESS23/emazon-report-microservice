package com.emazon.microservicio_reporte.adapters.driving.controller;

import com.emazon.microservicio_reporte.adapters.driving.dto.request.AddReportRequest;
import com.emazon.microservicio_reporte.adapters.driving.mapper.IReportRequestMapper;
import com.emazon.microservicio_reporte.adapters.driving.util.DrivingConstants;
import com.emazon.microservicio_reporte.domain.api.IReportServicePort;
import com.emazon.microservicio_reporte.domain.model.Report;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/report")
@RequiredArgsConstructor
@Tag(name = DrivingConstants.TAG_REPORT_NAME, description = DrivingConstants.TAG_REPORT_DESCRIPTION)
public class ReportRestController {
    private final IReportServicePort reportServicePort;
    private final IReportRequestMapper reportRequestMapper;

    @Operation(summary = DrivingConstants.SAVE_REPORT_SUMMARY, description = DrivingConstants.SAVE_REPORT_DESCRIPTION)
    @ApiResponses(value = {
            @ApiResponse(responseCode = DrivingConstants.RESPONSE_CODE_201, description = DrivingConstants.SAVE_REPORT_RESPONSE_201_DESCRIPTION),
            @ApiResponse(responseCode = DrivingConstants.RESPONSE_CODE_400, description = DrivingConstants.SAVE_REPORT_RESPONSE_400_DESCRIPTION, content = @Content)
    })
    @PreAuthorize(DrivingConstants.HAS_ROLE_CLIENT)
    @PostMapping
    public ResponseEntity<HttpStatus> addReport(@Valid @RequestBody AddReportRequest request) {
        Report report = reportRequestMapper.addRequestToReport(request);
        reportServicePort.saveReport(report);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
