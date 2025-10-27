package com.kurios.f1_analysis.event_session;

import com.kurios.f1_analysis.event_round.EventRound;
import com.kurios.f1_analysis.session_name.SessionName;
import org.springframework.stereotype.Service;

@Service
public class EventSessionMapper {

    public EventSession toSession(EventSessionDto eventSessionDto, EventRound eventRound, SessionName sessionName) {
        var sessions = new EventSession();
        sessions.setSessionName(sessionName);
        sessions.setSessionDate(eventSessionDto.sessionDate());
        sessions.setEventRound(eventRound);

        return sessions;
    }

    public EventSessionResponseDto toSessionResponseDto(EventSession sessions) {

        return new EventSessionResponseDto(
                sessions.getEventRound().getRoundNumber(),
                sessions.getSessionName().getId(),
                sessions.getSessionDate()
        );
    }

}
