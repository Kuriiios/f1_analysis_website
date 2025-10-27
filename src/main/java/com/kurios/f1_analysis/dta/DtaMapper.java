package com.kurios.f1_analysis.dta;

import com.kurios.f1_analysis.driver.Driver;
import com.kurios.f1_analysis.event_session.EventSession;
import com.kurios.f1_analysis.team.Team;
import org.springframework.stereotype.Service;

@Service
public class DtaMapper {
    public Dta toDriverTeamAssignment(EventSession eventSessionId, Driver driverId, Team teamId) {
        return new Dta(
                eventSessionId,
                driverId,
                teamId
        );
    }

    public DtaResponseDto toDriverTeamAssignmentResponseDto(Dta driverTeamAssignment) {
        return new DtaResponseDto(
                driverTeamAssignment.getSession().getId(),
                driverTeamAssignment.getDriver().getId(),
                driverTeamAssignment.getTeam().getId()
        );
    }
}
