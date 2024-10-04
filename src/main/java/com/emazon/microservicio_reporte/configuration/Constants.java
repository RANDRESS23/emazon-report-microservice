package com.emazon.microservicio_reporte.configuration;

public class Constants {
    private Constants(){
        throw new IllegalStateException("utility class");
    }

    public static final String USER_ID_FIELD  = "userId";
    public static final String ROLE_FIELD  = "role";
    public static final String AUTHORIZATION_HEADER  = "Authorization";
    public static final String BEARER_HEADER  = "Bearer ";
}
