package com.kurios.f1_analysis.weather;

public record WeatherResponseDto(
        Integer sessionId,
        Integer windDirectionId,
        Short airTemp,
        Short humidity,
        Short pressure,
        Boolean rainfall,
        Short trackTemp,
        Short windSpeed
) {
}
