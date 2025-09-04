package com.kurios.f1_analysis.session;

import java.sql.Date;

public record SessionDto(
        Integer eventRoundId,

        String sessionName,

        Date sessionDate

) {
}
