package com.kurios.f1_analysis.car_data;

import java.util.Date;

public record CarDataResponseDto(
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
        Boolean isBraking,
        Float distance,
        Float differentialDistance,
        Float relativeDistance,
        Integer distanceDriverAhead
) {
}
