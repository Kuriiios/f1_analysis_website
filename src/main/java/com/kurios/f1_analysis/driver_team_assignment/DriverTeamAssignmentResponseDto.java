package com.kurios.f1_analysis.driver_team_assignment;

public record DriverTeamAssignmentResponseDto(
        Integer session,
        Integer driver,
        Integer team
) {
}
