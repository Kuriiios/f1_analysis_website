package com.kurios.f1_analysis.pos_data;

import java.util.Date;

public record PosDataResponseDto(
        Integer dtaId,
        Integer trackStatus,
        Date dateTime,
        Integer time,
        Integer sessionTime,
        Short x,
        Short y,
        Short z,
        Boolean isCarOnTrack
) {
}
