package com.kurios.f1_analysis.session;

import java.util.Date;

public record SessionResponseDto(
        Short roundNumber,

        Integer sessionNameId,

        Date sessionDate

) {
}
