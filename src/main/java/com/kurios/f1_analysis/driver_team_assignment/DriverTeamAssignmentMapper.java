package com.kurios.f1_analysis.driver_team_assignment;

import com.kurios.f1_analysis.driver.Driver;
import com.kurios.f1_analysis.session.Session;
import com.kurios.f1_analysis.team.Team;
import org.springframework.stereotype.Service;

@Service
public class DriverTeamAssignmentMapper {
    public DriverTeamAssignment toDriverTeamAssignment(Session sessionId, Driver driverId, Team teamId) {
        return new DriverTeamAssignment(
                sessionId,
                driverId,
                teamId
        );
    }

    public DriverTeamAssignmentResponseDto toDriverTeamAssignmentResponseDto(DriverTeamAssignment driverTeamAssignment) {
        return new DriverTeamAssignmentResponseDto(
                driverTeamAssignment.getSession().getId(),
                driverTeamAssignment.getDriver().getId(),
                driverTeamAssignment.getTeam().getId()
        );
    }
}
