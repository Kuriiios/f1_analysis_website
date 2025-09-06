package com.kurios.f1_analysis.event_round;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventRoundService {

    private final EventRoundRepository eventRoundRepository;

    private final EventRoundMapper eventRoundMapper;

    public EventRoundService(EventRoundRepository eventRoundRepository, EventRoundMapper eventRoundMapper) {
        this.eventRoundRepository = eventRoundRepository;
        this.eventRoundMapper = eventRoundMapper;
    }

    public EventRoundResponseDto save(
            EventRoundDto eventRoundDto
    ) {
        var eventRound = eventRoundMapper.toEventRound(eventRoundDto);
        var savedEventRound = eventRoundRepository.save(eventRound);
        var eventRoundResponseDto = eventRoundMapper.toEventRoundResponseDto(savedEventRound);
        return eventRoundResponseDto;
    }

    public List<EventRoundResponseDto> findAll(
    ) {
        return eventRoundRepository.findAll()
                .stream()
                .map(eventRoundMapper::toEventRoundResponseDto)
                .collect(Collectors.toList());
    }

    public EventRoundResponseDto findById(Integer id) {
        return eventRoundRepository.findById(id)
                .map(eventRoundMapper::toEventRoundResponseDto)
                .orElse(null);
    }

    public EventRoundResponseDto findAllByRoundNumber(Short roundNumber) {
        return eventRoundRepository.findAllByRoundNumber(roundNumber)
                .map(eventRoundMapper::toEventRoundResponseDto)
                .orElse(null);
    }
}
