package com.kurios.f1_analysis.event_round;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EventRoundServiceTest {

    @InjectMocks
    private EventRoundService eventRoundService;

    @Mock
    private EventRoundRepository eventRoundRepository;

    @Mock
    private EventRoundMapper eventRoundMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void name() {
    }

    @Test
    public void should_save_an_event_round() {
        var date = Date.from(Instant.parse("2025-05-16T15:43:45Z"));
        EventRoundDto eventRoundDto = new EventRoundDto(
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
        EventRound savedEventRound = new EventRound(
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
        savedEventRound.setId(1);

        when(eventRoundMapper.toEventRound(eventRoundDto))
                .thenReturn(eventRound);
        when(eventRoundRepository.save(eventRound))
                .thenReturn(savedEventRound);
        when(eventRoundMapper.toEventRoundResponseDto(savedEventRound))
                .thenReturn(new EventRoundResponseDto(
                        (short) 2025,
                        (short) 1,
                        date,
                        false)
                );

        EventRoundResponseDto eventRoundResponseDto = eventRoundService.save(eventRoundDto);

        assertEquals(eventRoundDto.year(), eventRoundResponseDto.year());
        assertEquals(eventRoundDto.roundNumber(), eventRoundResponseDto.roundNumber());
        assertEquals(eventRoundDto.eventDate() , eventRoundResponseDto.eventDate());
        assertEquals(eventRoundDto.sprintEvent() , eventRoundResponseDto.sprintEvent());

        verify(eventRoundMapper, times(1))
                .toEventRound(eventRoundDto);
        verify(eventRoundRepository, times(1))
                .save(eventRound);
        verify(eventRoundMapper, times(1))
                .toEventRoundResponseDto(savedEventRound);
    }

    @Test
    public void should_find_all_event_rounds() {
        List<EventRound> eventRounds = new ArrayList<>();
        eventRounds.add(new EventRound(
                (short) 2025,
                (short) 1,
                "Australia",
                "Melbourne",
                "Australian Grand Prix",
                Date.from(Instant.parse("2025-05-16T15:43:45Z")),
                false,
                (short) 5,
                (short) 4,
                (short) 3
        ));

        when(eventRoundRepository.findAll())
                .thenReturn(eventRounds);
        when(eventRoundMapper.toEventRoundResponseDto(any(EventRound.class)))
                .thenReturn(new EventRoundResponseDto(
                        (short) 2025,
                        (short) 1,
                        Date.from(Instant.parse("2025-05-16T15:43:45Z")),
                        false
                ));

        List<EventRoundResponseDto> eventRoundResponseDtos = eventRoundService.findAll();

        assertEquals(eventRounds.size(), eventRoundResponseDtos.size());

        verify(eventRoundRepository, times(1))
                .findAll();
        verify(eventRoundMapper, times(1))
                .toEventRoundResponseDto(any(EventRound.class));
    }

    @Test
    public void should_find_event_round_by_id() {
        Integer eventRoundId = 1;
        EventRound eventRound = new EventRound(
                (short) 2025,
                (short) 1,
                "Australia",
                "Melbourne",
                "Australian Grand Prix",
                Date.from(Instant.parse("2025-05-16T15:43:45Z")),
                false,
                (short) 5,
                (short) 4,
                (short) 3
        );

        when(eventRoundRepository.findById(eventRoundId))
                .thenReturn(Optional.of(eventRound));
        when(eventRoundMapper.toEventRoundResponseDto(any(EventRound.class)))
                .thenReturn(new EventRoundResponseDto(
                        (short) 2025,
                        (short) 1,
                        Date.from(Instant.parse("2025-05-16T15:43:45Z")),
                        false
                ));

        EventRoundResponseDto eventRoundResponseDto = eventRoundService.findById(eventRoundId);

        assertEquals(eventRound.getYear(), eventRoundResponseDto.year());
        assertEquals(eventRound.getRoundNumber(), eventRoundResponseDto.roundNumber());
        assertEquals(eventRound.getEventDate() , eventRoundResponseDto.eventDate());
        assertEquals(eventRound.getSprintEvent() , eventRoundResponseDto.sprintEvent());

        verify(eventRoundRepository, times(1))
                .findById(eventRoundId);
        verify(eventRoundMapper, times(1))
                .toEventRoundResponseDto(any(EventRound.class));
    }

    @Test
    public void should_find_event_round_by_round_number() {
        Short roundNumber = 1;
        EventRound eventRound = new EventRound(
                (short) 2025,
                (short) 1,
                "Australia",
                "Melbourne",
                "Australian Grand Prix",
                Date.from(Instant.parse("2025-05-16T15:43:45Z")),
                false,
                (short) 5,
                (short) 4,
                (short) 3
        );

        when(eventRoundRepository.findAllByRoundNumber(roundNumber))
                .thenReturn(Optional.of(eventRound));
        when(eventRoundMapper.toEventRoundResponseDto(any(EventRound.class)))
                .thenReturn(new EventRoundResponseDto(
                        (short) 2025,
                        (short) 1,
                        Date.from(Instant.parse("2025-05-16T15:43:45Z")),
                        false
                ));

        EventRoundResponseDto eventRoundResponseDto = eventRoundService.findAllByRoundNumber(roundNumber);

        assertEquals(eventRound.getYear(), eventRoundResponseDto.year());
        assertEquals(eventRound.getRoundNumber(), eventRoundResponseDto.roundNumber());
        assertEquals(eventRound.getEventDate() , eventRoundResponseDto.eventDate());
        assertEquals(eventRound.getSprintEvent() , eventRoundResponseDto.sprintEvent());

        verify(eventRoundRepository, times(1))
                .findAllByRoundNumber(roundNumber);
        verify(eventRoundMapper, times(1))
                .toEventRoundResponseDto(any(EventRound.class));
    }
}