package com.kurios.f1_analysis.event_round;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.util.Date;

public record EventRoundDto(
        @NotNull @Max(2025) Short year,
        @Min(1) @Max(24) Short roundNumber,
        String country,
        String location,
        String eventName,
        @PastOrPresent Date eventDate,
        Boolean isSprintEvent,
        @Min(3) @Max(6) Short soft,
        @Min(2) @Max(5) Short medium,
        @Min(1) @Max(4)Short hard
) {
}
