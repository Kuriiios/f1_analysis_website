package com.kurios.f1_analysis.pos_data;

import com.kurios.f1_analysis.lap.LapRepository;
import com.kurios.f1_analysis.track_status.TrackStatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PosDataService {

    private final  PosDataRepository posDataRepository;

    private final PosDataMapper posDataMapper;

    private final LapRepository lapRepository;

    private final TrackStatusRepository trackStatusRepository;

    public PosDataService(PosDataRepository posDataRepository, PosDataMapper posDataMapper, LapRepository lapRepository, TrackStatusRepository trackStatusRepository) {
        this.posDataRepository = posDataRepository;
        this.posDataMapper = posDataMapper;
        this.lapRepository = lapRepository;
        this.trackStatusRepository = trackStatusRepository;
    }

    public PosDataResponseDto create(PosDataDto posDataDto) {
        var lap = lapRepository.findById(posDataDto.lapId())
                .orElseThrow(()-> new RuntimeException("Lap not found"));
        var trackStatus = trackStatusRepository.findById(posDataDto.trackStatusId())
                .orElseThrow(() -> new RuntimeException("DriverTeamAssignment not found"));
        var posData = posDataMapper.toPosData(posDataDto, lap, trackStatus);
        posDataRepository.save(posData);
        return posDataMapper.toPosDataResponseDto(posData);
    }

    public List<PosDataResponseDto> findAll() {
        return posDataRepository.findAll()
                .stream()
                .map(posDataMapper::toPosDataResponseDto)
                .toList();
    }
}
