package com.kurios.f1_analysis.session;

import com.kurios.f1_analysis.event_round.EventRound;
import com.kurios.f1_analysis.session_name.SessionName;
import org.springframework.stereotype.Service;

@Service
public class SessionMapper {

    public Session toSession(SessionDto sessionDto, EventRound eventRound, SessionName sessionName) {
        var sessions = new Session();
        sessions.setSessionName(sessionName);
        sessions.setSessionDate(sessionDto.sessionDate());
        sessions.setEventRound(eventRound);

        return sessions;
    }

    public SessionResponseDto toSessionResponseDto(Session sessions) {

        return new SessionResponseDto(
                sessions.getEventRound().getRoundNumber(),
                sessions.getSessionName().getId(),
                sessions.getSessionDate()
        );
    }

}
