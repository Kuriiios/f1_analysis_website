package com.kurios.f1_analysis.event_round;

import java.util.Date;

public record EventRoundDto(
        Short year,
        Short roundNumber,
        String country,
        String location,
        String eventName,
        Date eventDate,
        Boolean sprintEvent,
        Short soft,
        Short medium,
        Short hard
) {
}

