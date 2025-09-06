package com.kurios.f1_analysis.driver;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record DriverDto(
        @Min(1) @Max(99) Short driverNumber,
        @NotEmpty @Size(min=3, max=3) String driverAbbreviation,
        @NotEmpty String driverName,
        @Size(min=7, max=7) String driverHexColor,
        String country
) {
}
