package com.kurios.f1_analysis.event_round;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventRoundController {

    private final EventRoundService eventRoundService;

    public EventRoundController(EventRoundService eventRoundService) {
        this.eventRoundService = eventRoundService;
    }

    @PostMapping("/event-round")
    public EventRoundResponseDto create(@RequestBody EventRoundDto eventRoundDto) {
        return eventRoundService.create(eventRoundDto);
    }

    @GetMapping("/event-round")
    public List<EventRoundResponseDto> findAll() {
        return eventRoundService.findAll();
    }
}
