package com.kurios.f1_analysis.driver_team_assignment;

import jakarta.validation.constraints.NotNull;

public record DriverTeamAssignmentDto(

        @NotNull Integer sessionId,
        @NotNull Integer driverId,
        @NotNull Integer teamId
) {
}
