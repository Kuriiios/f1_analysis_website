package com.kurios.f1_analysis.event_round;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventRoundController {

    private final EventRoundRepository eventRoundRepository;

    public EventRoundController(EventRoundRepository eventRoundRepository) {
        this.eventRoundRepository = eventRoundRepository;
    }


    @PostMapping("/event-round")
    public EventRound create(@RequestBody EventRound eventRound) {
        return eventRoundRepository.save(eventRound);
    }

    @GetMapping("/event-round")
    public List<EventRound> findAll() {
        return eventRoundRepository.findAll();
    }
}
