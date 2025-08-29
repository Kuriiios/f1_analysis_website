package com.kurios.f1_analysis.pos_data;

import com.kurios.f1_analysis.lap.Lap;
import com.kurios.f1_analysis.track_status.TrackStatus;
import org.springframework.stereotype.Service;

@Service
public class PosDataMapper {

    public PosData toPosData(PosDataDto posDataDto, Lap lap, TrackStatus trackStatus) {
        return new PosData(
                lap,
                trackStatus,
                posDataDto.dateTime(),
                posDataDto.time(),
                posDataDto.sessionTime(),
                posDataDto.x(),
                posDataDto.y(),
                posDataDto.z(),
                posDataDto.carOnTrack()
        );
    }

    public PosDataResponseDto toPosDataResponseDto(PosData posData) {
        return new PosDataResponseDto(
                posData.getPosDataLap().getId(),
                posData.getTrackStatus().getId(),
                posData.getDateTime(),
                posData.getTime(),
                posData.getSessionTime(),
                posData.getX(),
                posData.getY(),
                posData.getZ(),
                posData.getCarOnTrack()
        );
    }
}
