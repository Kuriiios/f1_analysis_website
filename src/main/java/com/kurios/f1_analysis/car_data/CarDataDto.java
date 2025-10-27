package com.kurios.f1_analysis.car_data;

import jakarta.validation.constraints.*;

import java.util.Date;

public record CarDataDto(
        @NotNull Integer dtaId,
        @Min(0) @Max(14) Integer drsId,
        Integer trackStatus,
        @PastOrPresent Date dateTime,
        @PositiveOrZero Integer time,
        @PositiveOrZero Integer sessionTime,
        @Min(0) @Max(15000) Short rpm,
        @Min(0) @Max(399) Short speed,
        @Min(0) @Max(8) Short nGear,
        @Min(0) @Max(100) Short throttle,
        Boolean isBraking,
        @PositiveOrZero Float distance,
        @PositiveOrZero Float differentialDistance,
        Float relativeDistance,
        @PositiveOrZero Integer distanceDriverAhead
) {
}
