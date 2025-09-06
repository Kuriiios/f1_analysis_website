package com.kurios.f1_analysis.session;

import com.kurios.f1_analysis.event_round.EventRound;
import org.springframework.stereotype.Service;

@Service
public class SessionMapper {

    public Session toSession(SessionDto sessionDto, EventRound eventRound) {
        var sessions = new Session();
        sessions.setSessionName(sessionDto.sessionName());
        sessions.setSessionDate(sessionDto.sessionDate());
        sessions.setEventRound(eventRound);

        return sessions;
    }

    public SessionResponseDto toSessionResponseDto(Session sessions) {

        return new SessionResponseDto(
                sessions.getEventRound().getRoundNumber(),
                sessions.getSessionName(),
                sessions.getSessionDate()
        );
    }

}
