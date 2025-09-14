package com.kurios.f1_analysis.event_round;

import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventRoundService {

    private final RestTemplate restTemplate = new RestTemplate();

    private final EventRoundRepository eventRoundRepository;

    private final EventRoundMapper eventRoundMapper;

    public EventRoundService(EventRoundRepository eventRoundRepository, EventRoundMapper eventRoundMapper) {
        this.eventRoundRepository = eventRoundRepository;
        this.eventRoundMapper = eventRoundMapper;
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

    public List<EventRoundDto> getEventRounds(int year) {
        String url = "http://127.0.0.1:8000/event-rounds/" + year;
        ResponseEntity<EventRoundDto[]> response =
            restTemplate.getForEntity(url, EventRoundDto[].class);
        return Arrays.asList(response.getBody());
    }

    @Transactional
    public void saveRacesForSeason(int year) {
        List<EventRoundDto> eventRounds = getEventRounds(year);
        for (EventRoundDto eventRound : eventRounds) {
            EventRound eventRoundEntity = eventRoundMapper.toEventRound(eventRound);
            eventRoundRepository.save(eventRoundEntity);
        }
    }
}
