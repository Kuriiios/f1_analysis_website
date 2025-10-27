package com.kurios.f1_analysis.weather;

import jakarta.validation.constraints.NotNull;

public record WeatherResponseDto(
        Integer sessionId,
        Integer time,
        Short windDirection,
        Short airTemp,
        Short humidity,
        Short pressure,
        Boolean rainfall,
        Short trackTemp,
        Short windSpeed
) {
}
