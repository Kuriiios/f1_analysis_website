package com.kurios.f1_analysis.event_session;

import java.util.Date;

public record EventSessionResponseDto(
        Short roundNumber,

        Integer sessionNameId,

        Date sessionDate

) {
}
