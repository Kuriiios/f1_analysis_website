package com.kurios.f1_analysis.sessions;

import java.sql.Date;

public record SessionsResponseDto(
        Short roundNumber,

        String sessionName,

        Date sessionDate

) {
}
