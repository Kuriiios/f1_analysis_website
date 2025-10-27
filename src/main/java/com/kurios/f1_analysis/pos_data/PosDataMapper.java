package com.kurios.f1_analysis.pos_data;

import com.kurios.f1_analysis.dta.Dta;
import org.springframework.stereotype.Service;

@Service
public class PosDataMapper {

    public PosData toPosData(PosDataDto posDataDto, Dta dta) {
        return new PosData(
                dta,
                posDataDto.trackStatus(),
                posDataDto.dateTime(),
                posDataDto.time(),
                posDataDto.sessionTime(),
                posDataDto.x(),
                posDataDto.y(),
                posDataDto.z(),
                posDataDto.isCarOnTrack()
        );
    }

    public PosDataResponseDto toPosDataResponseDto(PosData posData) {
        return new PosDataResponseDto(
                posData.getPosDataDta().getId(),
                posData.getTrackStatus(),
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
