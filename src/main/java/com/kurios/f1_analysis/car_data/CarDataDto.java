package com.kurios.f1_analysis.car_data;

import com.kurios.f1_analysis.drs.Drs;
import com.kurios.f1_analysis.lap.Lap;
import com.kurios.f1_analysis.track_status.TrackStatus;

import java.util.Date;

public record CarDataDto(
        Integer lapId,
        Integer drsId,
        Integer trackStatusId,
        Date dateTime,
        Integer time,
        Integer sessionTime,
        Short rpm,
        Short speed,
        Short nGear,
        Short throttle,
        Boolean brake,
        Float distance,
        Float differentialDistance,
        Float relativeDistance,
        Integer distanceDriverAhead
) {
}
