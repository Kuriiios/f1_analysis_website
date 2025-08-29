package com.kurios.f1_analysis.sessions;

import java.sql.Date;

public record SessionsDto(
        Integer eventRoundId,

        String sessionName,

        Date sessionDate

) {
}
