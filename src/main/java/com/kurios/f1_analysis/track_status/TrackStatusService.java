package com.kurios.f1_analysis.track_status;

import com.kurios.f1_analysis.event_round.EventRoundResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrackStatusService {

    private final TrackStatusMapper trackStatusMapper;

    private final TrackStatusRepository trackStatusRepository;

    public TrackStatusService(TrackStatusMapper trackStatusMapper, TrackStatusRepository trackStatusRepository) {
        this.trackStatusMapper = trackStatusMapper;
        this.trackStatusRepository = trackStatusRepository;
    }

    public List<TrackStatusResponseDto> findAll() {
        return trackStatusRepository.findAll()
                .stream()
                .map(trackStatusMapper::toTrackStatusResponseDto)
                .collect(Collectors.toList());
    }

    public TrackStatusResponseDto findById(Integer id) {
        return trackStatusRepository.findById(id)
                .map(trackStatusMapper::toTrackStatusResponseDto)
                .orElse(null);
    }

}
