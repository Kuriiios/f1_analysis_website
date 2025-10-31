package com.kurios.f1_analysis.race_control;

import java.util.Date;

public record RaceControlResponseDto(
        Integer raceControlId,
        Date dateTime,
        String raceControlMessage
) {
}
