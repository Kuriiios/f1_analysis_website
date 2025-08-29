package com.kurios.f1_analysis.driver;

public record DriverDto(
        Short driverNumber,
        String driverAbbreviation,
        String driverName,
        String driverHexColor,
        String country
) {
}
