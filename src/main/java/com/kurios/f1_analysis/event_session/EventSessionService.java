package com.kurios.f1_analysis.event_session;

import com.kurios.f1_analysis.event_round.EventRound;
import com.kurios.f1_analysis.event_round.EventRoundRepository;
import com.kurios.f1_analysis.session_name.SessionName;
import com.kurios.f1_analysis.session_name.SessionNameRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EventSessionService {

    private final SessionNameRepository sessionNameRepository;
    private RestTemplate restTemplate = new RestTemplate();

    private final EventSessionRepository eventSessionRepository;

    private final EventSessionMapper eventSessionMapper;

    private final EventRoundRepository eventRoundRepository;


    public EventSessionService(EventSessionRepository eventSessionRepository, EventSessionMapper eventSessionMapper, EventRoundRepository eventRoundRepository, SessionNameRepository sessionNameRepository) {
        this.eventSessionRepository = eventSessionRepository;
        this.eventSessionMapper = eventSessionMapper;
        this.eventRoundRepository = eventRoundRepository;
        this.sessionNameRepository = sessionNameRepository;
    }


    @Transactional
    public void saveAllSessions(Integer year) {
        String url = "http://127.0.0.1:8000/sessions/" + year;
        ResponseEntity<EventSessionDto[]> response =
                restTemplate.getForEntity(url, EventSessionDto[].class);

        EventSessionDto[] sessions = response.getBody();

        Map<Integer, EventRound> eventRoundCache = new HashMap<>();


        for  (EventSessionDto eventSessionDto : sessions) {
            Short roundNumber = eventSessionDto.roundNumber();
            EventRound eventRoundEntity = eventRoundRepository.findAllByRoundNumber(roundNumber)
                    .orElseThrow(() -> new RuntimeException("Event Round not found for round " + roundNumber));
            Date dateTime = eventSessionDto.sessionDate();
            SessionName sessionName = sessionNameRepository.getSessionNameById(eventSessionDto.sessionNameId());

            boolean exists = eventSessionRepository.existsByEventRoundAndSessionNameAndSessionDate(
                    eventRoundEntity, sessionName, dateTime);

            if (!exists) {
                EventSession eventSessionEntity = new EventSession(
                        eventRoundEntity,
                        dateTime,
                        sessionName
                );
                eventSessionRepository.save(eventSessionEntity);
            }
        }
    }

    @Transactional
    public void saveSessionForRoundNumber(Integer year, Short roundNumber) {
        String url = "http://127.0.0.1:8000/sessions/" + year + "/" + roundNumber;
        ResponseEntity<EventSessionDto[]> response =
                restTemplate.getForEntity(url, EventSessionDto[].class);

        EventSessionDto[] sessions = response.getBody();
        EventRound eventRoundEntity = eventRoundRepository.findAllByRoundNumber(roundNumber)
                .orElseThrow(() -> new RuntimeException("Event Round not found for round " + roundNumber));

        for  (EventSessionDto eventSessionDto : sessions) {
            Date dateTime = eventSessionDto.sessionDate();
            SessionName sessionName = sessionNameRepository.getSessionNameById(eventSessionDto.sessionNameId());

            boolean exists = eventSessionRepository.existsByEventRoundAndSessionNameAndSessionDate(
                    eventRoundEntity, sessionName, dateTime);

            if (!exists) {
                EventSession eventSessionEntity = new EventSession(
                        eventRoundEntity,
                        dateTime,
                        sessionName
                );
                eventSessionRepository.save(eventSessionEntity);
            }
        }
    }

    public List<EventSessionResponseDto> findAll() {
        return eventSessionRepository.findAll()
                .stream()
                .map(eventSessionMapper::toSessionResponseDto)
                .collect(Collectors.toList()
                );
    }

    public EventSessionResponseDto findById(Integer id) {
        return eventSessionRepository.findById(id)
                .map(eventSessionMapper::toSessionResponseDto)
                .orElse(null);
    }
}
