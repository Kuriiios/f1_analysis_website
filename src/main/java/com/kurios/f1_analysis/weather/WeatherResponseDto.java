package com.kurios.f1_analysis.weather;

import com.kurios.f1_analysis.sessions.Sessions;
import com.kurios.f1_analysis.wind_direction.WindDirection;

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
