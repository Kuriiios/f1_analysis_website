package com.kurios.f1_analysis.dta;

import jakarta.validation.constraints.NotNull;

public record DtaDto(

        @NotNull Integer sessionId,
        @NotNull Integer driverId,
        @NotNull Integer teamId
) {
}
