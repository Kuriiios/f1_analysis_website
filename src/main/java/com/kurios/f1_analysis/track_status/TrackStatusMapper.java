package com.kurios.f1_analysis.track_status;

import org.springframework.stereotype.Service;

@Service
public class TrackStatusMapper {

    public TrackStatusResponseDto toTrackStatusResponseDto(TrackStatus trackStatus) {
        return new TrackStatusResponseDto(
                trackStatus.getId(),
                trackStatus.getTrackState()
        );
    }
}
