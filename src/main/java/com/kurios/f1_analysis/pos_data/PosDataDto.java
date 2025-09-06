package com.kurios.f1_analysis.pos_data;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.Date;

public record PosDataDto(
        @NotNull Integer lapId,
        Integer trackStatusId,
        @NotNull @PastOrPresent Date dateTime,
        @PositiveOrZero Integer time,
        @PositiveOrZero Integer sessionTime,
        Short x,
        Short y,
        Short z,
        Boolean IsCarOnTrack
) {
}
