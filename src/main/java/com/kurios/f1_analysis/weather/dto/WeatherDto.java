package com.kurios.f1_analysis.weather.dto;


import jakarta.validation.constraints.*;

public record WeatherDto(
        @NotNull Integer sessionId,
        @NotNull Integer time,
        Short windDirection,
        Short airTemp,
        @Min(0) @Max(100) Short humidity,
        @Positive Short pressure,
        Boolean rainfall,
        Short trackTemp,
        @PositiveOrZero Short windSpeed
) {
}
