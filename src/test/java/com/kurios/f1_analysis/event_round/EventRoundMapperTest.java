package com.kurios.f1_analysis.event_round;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class EventRoundMapperTest {

    private EventRoundMapper eventRoundMapper;

    @BeforeEach
    void setUp() {
        eventRoundMapper = new EventRoundMapper();
    }

    @Test
    public void should_throw_null_pointer_exception_when_eventRoundDto_is_null() {
        var msg = assertThrows(NullPointerException.class, () -> eventRoundMapper.toEventRound(null));
        assertEquals(msg.getMessage(), "eventRoundDto should not be null");
    }

    @Test
    public void shouldMapEventRoundToEventRoundResponseDto(){
        var date = Date.from(Instant.parse("2025-05-16T15:43:45Z"));
        EventRound eventRound = new EventRound(
                (short) 2025,
                (short) 1,
                "Australia",
                "Melbourne",
                "Australian Grand Prix",
                date,
                false,
                (short) 5,
                (short) 4,
                (short) 3
        );

        EventRoundResponseDto eventRoundResponseDto = eventRoundMapper.toEventRoundResponseDto(eventRound);

        assertEquals(eventRoundResponseDto.year(), eventRound.getYear());
        assertEquals(eventRoundResponseDto.roundNumber(), eventRound.getRoundNumber());
        assertEquals(eventRoundResponseDto.eventDate(), eventRound.getEventDate());
        assertEquals(eventRoundResponseDto.sprintEvent(), eventRound.getSprintEvent());
    }
}