package com.kurios.f1_analysis.session;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.sql.Date;

public record SessionDto(
        @NotNull Integer eventRoundId,
        @NotEmpty String sessionName,
        @PastOrPresent Date sessionDate

) {
}
