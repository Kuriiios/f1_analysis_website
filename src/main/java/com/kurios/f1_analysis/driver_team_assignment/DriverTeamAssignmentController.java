package com.kurios.f1_analysis.driver_team_assignment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DriverTeamAssignmentController {
    private final DriverTeamAssignmentRepository driverTeamAssignmentRepository;

    public DriverTeamAssignmentController(DriverTeamAssignmentRepository driverTeamAssignmentRepository) {
        this.driverTeamAssignmentRepository = driverTeamAssignmentRepository;
    }

    @PostMapping("/driver-team-assignment")
    public DriverTeamAssignment create(@RequestBody DriverTeamAssignment driverTeamAssignment) {
        return driverTeamAssignmentRepository.save(driverTeamAssignment);
    }

    @GetMapping("/driver-team-assignment")
    public List<DriverTeamAssignment>  findAll() {
        return driverTeamAssignmentRepository.findAll();
    }
}
