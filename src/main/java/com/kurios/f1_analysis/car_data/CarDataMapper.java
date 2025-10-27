package com.kurios.f1_analysis.car_data;

import com.kurios.f1_analysis.drs.Drs;
import com.kurios.f1_analysis.dta.Dta;
import org.springframework.stereotype.Service;

@Service
public class CarDataMapper {

    public CarData toCarData(CarDataDto carDataDto, Dta dta, Drs drs) {
        return new CarData(
                dta,
                drs,
                carDataDto.trackStatus(),
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
                carData.getCarDataDta().getId(),
                carData.getDrs().getId(),
                carData.getTrackStatus(),
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
