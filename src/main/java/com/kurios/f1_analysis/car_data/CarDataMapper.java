package com.kurios.f1_analysis.car_data;

import com.kurios.f1_analysis.drs.Drs;
import com.kurios.f1_analysis.lap.Lap;
import com.kurios.f1_analysis.track_status.TrackStatus;
import org.springframework.stereotype.Service;

@Service
public class CarDataMapper {

    public CarData toCarData(CarDataDto carDataDto, Lap lap, Drs drs, TrackStatus trackStatus) {
        return new CarData(
                lap,
                drs,
                trackStatus,
                carDataDto.dateTime(),
                carDataDto.time(),
                carDataDto.sessionTime(),
                carDataDto.rpm(),
                carDataDto.speed(),
                carDataDto.nGear(),
                carDataDto.throttle(),
                carDataDto.isBraking(),
                carDataDto.distance(),
                carDataDto.differentialDistance(),
                carDataDto.relativeDistance(),
                carDataDto.distanceDriverAhead()
        );
    }

    public CarDataResponseDto toCarDataResponseDto(CarData carData) {
        return new CarDataResponseDto(
                carData.getCarDataLap().getId(),
                carData.getDrs().getId(),
                carData.getTrackStatus().getId(),
                carData.getDateTime(),
                carData.getTime(),
                carData.getSessionTime(),
                carData.getnGear(),
                carData.getnGear(),
                carData.getnGear(),
                carData.getnGear(),
                carData.getBraking(),
                carData.getDistance(),
                carData.getDifferentialDistance(),
                carData.getRelativeDistance(),
                carData.getDistanceDriverAhead()
        );
    }
}
