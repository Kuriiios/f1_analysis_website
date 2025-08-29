package com.kurios.f1_analysis.track_status;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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

}
