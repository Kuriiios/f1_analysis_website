package com.kurios.f1_analysis.lap;

import java.util.Date;

public record LapResponseDto(
        Integer compoundId,
        Integer driverTeamAssignmentId,
        Integer trackStatus,
        Integer laptimeMs,
        Short lapNumber,
        Short stint,
        Integer pitInTime,
        Integer pitOutTime,
        Integer sector1Time,
        Integer sector2Time,
        Integer sector3Time,
        Integer sector1SessionTime,
        Integer sector2SessionTime,
        Integer sector3SessionTime,
        Short speedI1,
        Short speedI2,
        Short speedFl,
        Short speedSt,
        Boolean isPersonalBest,
        Short tyreLife,
        Integer lapStartTime,
        Date lapStartDate,
        Short position,
        Boolean isDeleted,
        Boolean isAccurate
) {
}
