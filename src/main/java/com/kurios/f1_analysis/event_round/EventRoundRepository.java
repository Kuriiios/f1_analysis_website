package com.kurios.f1_analysis.event_round;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRoundRepository extends JpaRepository<EventRound, Integer> {

    List<EventRound> findAllByRoundNumber(Integer roundNumber);
}
