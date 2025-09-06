package com.kurios.f1_analysis.driver_team_assignment;

import com.kurios.f1_analysis.driver.DriverRepository;
import com.kurios.f1_analysis.event_round.EventRoundResponseDto;
import com.kurios.f1_analysis.session.SessionRepository;
import com.kurios.f1_analysis.team.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DriverTeamAssignmentService {
    private final DriverTeamAssignmentRepository driverTeamAssignmentRepository;
    private final DriverRepository driverRepository;
    private final TeamRepository teamRepository;
    private final SessionRepository sessionRepository;

    private final DriverTeamAssignmentMapper driverTeamAssignmentMapper;


    public DriverTeamAssignmentService(DriverTeamAssignmentRepository driverTeamAssignmentRepository, DriverRepository driverRepository, TeamRepository teamRepository, SessionRepository sessionRepository, DriverTeamAssignmentMapper driverTeamAssignmentMapper) {
        this.driverTeamAssignmentRepository = driverTeamAssignmentRepository;
        this.driverRepository = driverRepository;
        this.teamRepository = teamRepository;
        this.sessionRepository = sessionRepository;
        this.driverTeamAssignmentMapper = driverTeamAssignmentMapper;

    }

    public DriverTeamAssignment save(DriverTeamAssignmentDto driverTeamAssignmentDto) {
        var driverId = driverRepository.findById(driverTeamAssignmentDto.driverId())
                .orElseThrow(() -> new RuntimeException("Driver not found"));
        var teamId = teamRepository.findById(driverTeamAssignmentDto.teamId())
                .orElseThrow(() -> new RuntimeException("Team not found"));
        var sessionId = sessionRepository.findById(driverTeamAssignmentDto.sessionId())
                .orElseThrow(() -> new RuntimeException("Session not found"));
        var driverTeamAssignment = driverTeamAssignmentMapper.toDriverTeamAssignment(sessionId, driverId, teamId );
        driverTeamAssignmentRepository.save(driverTeamAssignment);
        return driverTeamAssignment;
    }

    public List<DriverTeamAssignmentResponseDto> findAll() {
        return driverTeamAssignmentRepository.findAll()
                .stream()
                .map(driverTeamAssignmentMapper::toDriverTeamAssignmentResponseDto)
                .collect(Collectors.toList());
    }

    public DriverTeamAssignmentResponseDto findById(Integer id) {
        return driverTeamAssignmentRepository.findById(id)
                .map(driverTeamAssignmentMapper::toDriverTeamAssignmentResponseDto)
                .orElse(null);
    }
}
