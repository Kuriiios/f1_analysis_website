package com.kurios.f1_analysis.event_round;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRoundRepository extends JpaRepository<EventRound, Integer> {

    EventRound findAllByRoundNumber(Short roundNumber);

    EventRound findAllById(Integer id);
}
