package com.kurios.f1_analysis.session;

import com.kurios.f1_analysis.event_round.EventRound;
import com.kurios.f1_analysis.session_name.SessionName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface SessionRepository extends JpaRepository<Session, Integer> {

    List<Session> findAll();

    Session findAllById(Integer id);

    boolean existsByEventRoundAndSessionNameAndSessionDate(
            EventRound eventRound,
            SessionName sessionName,
            Date sessionDate
    );
}
