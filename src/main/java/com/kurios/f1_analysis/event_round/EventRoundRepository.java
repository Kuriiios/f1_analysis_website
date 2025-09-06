package com.kurios.f1_analysis.event_round;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventRoundRepository extends JpaRepository<EventRound, Integer> {

    EventRound findAllById(Integer id);

    Optional<EventRound> findAllByRoundNumber(Short roundNumber);
}
