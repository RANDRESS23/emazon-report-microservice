package com.emazon.microservicio_reporte.adapters.driving.util;

public class DrivingConstants {
    private DrivingConstants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String HAS_ROLE_CLIENT = "hasRole('CLIENTE')";

    public static final String RESPONSE_CODE_201="201";
    public static final String RESPONSE_CODE_400="400";

    public static final String TAG_REPORT_NAME = "Report";
    public static final String TAG_REPORT_DESCRIPTION = "Report API";
    public static final String SAVE_REPORT_SUMMARY = "Save a new report";
    public static final String SAVE_REPORT_DESCRIPTION = "Creates a new report in the database";
    public static final String SAVE_REPORT_RESPONSE_201_DESCRIPTION = "Report created successfully";
    public static final String SAVE_REPORT_RESPONSE_400_DESCRIPTION = "Invalid input";
}
