package com.kurios.f1_analysis.lap;

import com.kurios.f1_analysis.compound.CompoundRepository;
import com.kurios.f1_analysis.driver_team_assignment.DriverTeamAssignmentRepository;
import com.kurios.f1_analysis.event_round.EventRoundResponseDto;
import com.kurios.f1_analysis.track_status.TrackStatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LapService {

    private final LapMapper lapMapper;

    private final LapRepository lapRepository;

    private final DriverTeamAssignmentRepository driverTeamAssignmentRepository;

    private final CompoundRepository compoundRepository;

    private final TrackStatusRepository trackStatusRepository;

    public LapService(LapMapper lapMapper, LapRepository lapRepository, DriverTeamAssignmentRepository driverTeamAssignmentRepository, CompoundRepository compoundRepository, TrackStatusRepository trackStatusRepository) {
        this.lapMapper = lapMapper;
        this.lapRepository = lapRepository;
        this.driverTeamAssignmentRepository = driverTeamAssignmentRepository;
        this.compoundRepository = compoundRepository;
        this.trackStatusRepository = trackStatusRepository;
    }

    public LapResponseDto save(LapDto lapDto) {
        var dta = driverTeamAssignmentRepository.findById(lapDto.driverTeamAssignmentId())
                .orElseThrow(() -> new RuntimeException("DriverTeamAssignment not found"));
        var compound = compoundRepository.findById(lapDto.compoundId())
                .orElseThrow(() -> new RuntimeException("Compound not found"));
        var trackStatus = trackStatusRepository.findById(lapDto.trackStatusId())
                .orElseThrow(() -> new RuntimeException("TrackStatus not found"));
        var lap = lapMapper.toLap(lapDto, dta, compound, trackStatus);
        lapRepository.save(lap);
        return  lapMapper.toLapResponseDto(lap);
    }

    public List<LapResponseDto> findAll() {
        return lapRepository.findAll()
                .stream()
                .map(lapMapper::toLapResponseDto)
                .toList();
    }

    public LapResponseDto findById(Integer id) {
        return lapRepository.findById(id)
                .map(lapMapper::toLapResponseDto)
                .orElse(null);
    }

    public List<LapResponseDto> findAllByDtaId(Integer dtaId) {
        return lapRepository.findAllByDriverTeamAssignment_Id(dtaId)
                .stream()
                .map(lapMapper::toLapResponseDto)
                .toList();
    }
}
