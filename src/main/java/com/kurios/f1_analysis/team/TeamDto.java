package com.kurios.f1_analysis.team;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public record TeamDto(
        @NotEmpty String teamName,
        @NotEmpty @Min(3) @Max(3) String teamAbbreviation,
        @Min(7) @Max(7) String teamHexColor
) {
}
