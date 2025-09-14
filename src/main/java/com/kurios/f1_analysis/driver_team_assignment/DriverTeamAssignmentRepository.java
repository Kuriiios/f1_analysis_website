package com.kurios.f1_analysis.driver_team_assignment;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DriverTeamAssignmentRepository extends JpaRepository<DriverTeamAssignment, Integer> {

    List<DriverTeamAssignment> findAllBySessionId(Integer sessionId);

    List<DriverTeamAssignment> findAllByDriverId(Integer driverId);

    List<DriverTeamAssignment> findAllByTeamId(Integer teamId);
}
