package com.kurios.f1_analysis.driver_team_assignment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DriverTeamAssignmentController {

    private final DriverTeamAssignmentService driverTeamAssignmentService;

    public DriverTeamAssignmentController(DriverTeamAssignmentService driverTeamAssignmentService) {
        this.driverTeamAssignmentService = driverTeamAssignmentService;
    }

    @PostMapping("/driver-team-assignment")
    public DriverTeamAssignment create(@RequestBody DriverTeamAssignmentDto driverTeamAssignmentDto) {
        return driverTeamAssignmentService.create(driverTeamAssignmentDto);
    }

    @GetMapping("/driver-team-assignment")
    public List<DriverTeamAssignmentResponseDto>  findAll() {
        return driverTeamAssignmentService.findAll();
    }
}
