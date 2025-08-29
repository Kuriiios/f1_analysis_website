package com.kurios.f1_analysis.sessions;

import com.kurios.f1_analysis.event_round.EventRound;
import org.springframework.stereotype.Service;

@Service
public class SessionsMapper {

    public Sessions toSessions(SessionsDto sessionsDto, EventRound eventRound) {
        var sessions = new Sessions();
        sessions.setSessionName(sessionsDto.sessionName());
        sessions.setSessionDate(sessionsDto.sessionDate());
        sessions.setEventRound(eventRound);

        return sessions;
    }

    public SessionsResponseDto toSessionsResponseDto(Sessions sessions) {

        return new SessionsResponseDto(
                sessions.getEventRound().getRoundNumber(),
                sessions.getSessionName(),
                sessions.getSessionDate()
        );
    }

}
