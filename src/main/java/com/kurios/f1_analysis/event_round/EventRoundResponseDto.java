package com.kurios.f1_analysis.event_round;

import java.util.Date;

public record EventRoundResponseDto(
        Short year,
        Short roundNumber,
        Date eventDate,
        Boolean sprintEvent
) {
}
