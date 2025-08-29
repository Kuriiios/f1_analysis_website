package com.kurios.f1_analysis.driver;

public record DriverResponseDto(
        Short driverNumber,
        String driverAbbreviation,
        String driverName
) {
}
