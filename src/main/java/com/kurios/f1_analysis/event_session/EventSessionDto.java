package com.kurios.f1_analysis.event_session;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.util.Date;

public record EventSessionDto(
        @NotNull Short roundNumber,
        @NotEmpty Integer sessionNameId,
        @PastOrPresent Date sessionDate

) {
}
