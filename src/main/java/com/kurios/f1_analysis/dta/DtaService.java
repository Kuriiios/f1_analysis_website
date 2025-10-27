package com.kurios.f1_analysis.dta;

import com.kurios.f1_analysis.driver.DriverRepository;
import com.kurios.f1_analysis.event_session.EventSessionRepository;
import com.kurios.f1_analysis.team.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DtaService {
    private final DtaRepository dtaRepository;
    private final DriverRepository driverRepository;
    private final TeamRepository teamRepository;
    private final EventSessionRepository eventSessionRepository;

    private final DtaMapper dtaMapper;


    public DtaService(DtaRepository dtaRepository, DriverRepository driverRepository, TeamRepository teamRepository, EventSessionRepository eventSessionRepository, DtaMapper dtaMapper) {
        this.dtaRepository = dtaRepository;
        this.driverRepository = driverRepository;
        this.teamRepository = teamRepository;
        this.eventSessionRepository = eventSessionRepository;
        this.dtaMapper = dtaMapper;

    }

    public Dta save(DtaDto dtaDto) {
        var driverId = driverRepository.findById(dtaDto.driverId())
                .orElseThrow(() -> new RuntimeException("Driver not found"));
        var teamId = teamRepository.findById(dtaDto.teamId())
                .orElseThrow(() -> new RuntimeException("Team not found"));
        var sessionId = eventSessionRepository.findById(dtaDto.sessionId())
                .orElseThrow(() -> new RuntimeException("Session not found"));
        var driverTeamAssignment = dtaMapper.toDriverTeamAssignment(sessionId, driverId, teamId );
        dtaRepository.save(driverTeamAssignment);
        return driverTeamAssignment;
    }

    public List<DtaResponseDto> findAll() {
        return dtaRepository.findAll()
                .stream()
                .map(dtaMapper::toDriverTeamAssignmentResponseDto)
                .collect(Collectors.toList());
    }

    public DtaResponseDto findById(Integer id) {
        return dtaRepository.findById(id)
                .map(dtaMapper::toDriverTeamAssignmentResponseDto)
                .orElse(null);
    }

    public List<DtaResponseDto> findAllBySessionId(Integer sessionId) {
        return dtaRepository.findAllByEventSessionId(sessionId)
                .stream()
                .map(dtaMapper::toDriverTeamAssignmentResponseDto)
                .collect(Collectors.toList());
    }

    public List<DtaResponseDto> findAllByDriverId(Integer driverId) {
        return dtaRepository.findAllByDriverId(driverId)
                .stream()
                .map(dtaMapper::toDriverTeamAssignmentResponseDto)
                .collect(Collectors.toList());
    }

    public List<DtaResponseDto> findAllByTeamId(Integer teamId) {
        return dtaRepository.findAllByTeamId(teamId)
                .stream()
                .map(dtaMapper::toDriverTeamAssignmentResponseDto)
                .collect(Collectors.toList());
    }
}
