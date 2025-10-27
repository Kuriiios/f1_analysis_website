package com.kurios.f1_analysis.event_session;

import com.kurios.f1_analysis.event_round.EventRound;
import com.kurios.f1_analysis.session_name.SessionName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface EventSessionRepository extends JpaRepository<EventSession, Integer> {

    List<EventSession> findAll();

    EventSession findAllById(Integer id);

    boolean existsByEventRoundAndSessionNameAndSessionDate(
            EventRound eventRound,
            SessionName sessionName,
            Date sessionDate
    );
}
