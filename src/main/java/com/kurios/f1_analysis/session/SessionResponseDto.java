package com.kurios.f1_analysis.session;

import java.sql.Date;

public record SessionResponseDto(
        Short roundNumber,

        String sessionName,

        Date sessionDate

) {
}
