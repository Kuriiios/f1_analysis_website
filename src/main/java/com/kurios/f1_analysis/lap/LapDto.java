package com.kurios.f1_analysis.lap;

import jakarta.validation.constraints.*;

import java.util.Date;

public record LapDto(
        @NotNull @Min(1) @Max(6) Integer compoundId,
        @NotNull(message = "Lap should be related to a dta object so I can be linked to a driver, a team and a session")  Integer dtaId,
        Integer trackStatus,
        @NotNull @PositiveOrZero Integer laptimeMs,
        @PositiveOrZero Short lapNumber,
        @PositiveOrZero Short stint,
        @PositiveOrZero Integer pitInTime,
        @PositiveOrZero Integer pitOutTime,
        @PositiveOrZero Integer sector1Time,
        @PositiveOrZero Integer sector2Time,
        @PositiveOrZero Integer sector3Time,
        @PositiveOrZero Integer sector1SessionTime,
        @PositiveOrZero Integer sector2SessionTime,
        @PositiveOrZero Integer sector3SessionTime,
        @PositiveOrZero Short speedI1,
        @PositiveOrZero Short speedI2,
        @PositiveOrZero Short speedFl,
        @PositiveOrZero Short speedSt,
        Boolean isPersonalBest,
        @Positive Short tyreLife,
        @NotNull @PositiveOrZero Integer lapStartTime,
        @NotNull @PastOrPresent Date lapStartDate,
        @Positive Short position,
        Boolean isDeleted,
        Boolean isAccurate
) {
}
