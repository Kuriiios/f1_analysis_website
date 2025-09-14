package com.kurios.f1_analysis.session;

import com.kurios.f1_analysis.event_round.EventRound;
import com.kurios.f1_analysis.event_round.EventRoundRepository;
import com.kurios.f1_analysis.session_name.SessionName;
import com.kurios.f1_analysis.session_name.SessionNameRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SessionService {

    private final SessionNameRepository sessionNameRepository;
    private RestTemplate restTemplate = new RestTemplate();

    private final SessionRepository sessionRepository;

    private final SessionMapper sessionMapper;

    private final EventRoundRepository eventRoundRepository;


    public SessionService(SessionRepository sessionRepository, SessionMapper sessionMapper, EventRoundRepository eventRoundRepository, SessionNameRepository sessionNameRepository) {
        this.sessionRepository = sessionRepository;
        this.sessionMapper = sessionMapper;
        this.eventRoundRepository = eventRoundRepository;
        this.sessionNameRepository = sessionNameRepository;
    }


    @Transactional
    public void saveAllSessions(Integer year) {
        String url = "http://127.0.0.1:8000/sessions/" + year;
        ResponseEntity<SessionDto[]> response =
                restTemplate.getForEntity(url, SessionDto[].class);

        SessionDto[] sessions = response.getBody();

        Map<Integer, EventRound> eventRoundCache = new HashMap<>();


        for  (SessionDto sessionDto : sessions) {
            Short roundNumber = sessionDto.roundNumber();
            EventRound eventRoundEntity = eventRoundRepository.findAllByRoundNumber(roundNumber)
                    .orElseThrow(() -> new RuntimeException("Event Round not found for round " + roundNumber));
            Date dateTime = sessionDto.sessionDate();
            SessionName sessionName = sessionNameRepository.getSessionNameById(sessionDto.sessionNameId());

            boolean exists = sessionRepository.existsByEventRoundAndSessionNameAndSessionDate(
                    eventRoundEntity, sessionName, dateTime);

            if (!exists) {
                Session sessionEntity = new Session(
                        eventRoundEntity,
                        dateTime,
                        sessionName
                );
                sessionRepository.save(sessionEntity);
            }
        }
    }

    @Transactional
    public void saveSessionForRoundNumber(Integer year, Short roundNumber) {
        String url = "http://127.0.0.1:8000/sessions/" + year + "/" + roundNumber;
        ResponseEntity<SessionDto[]> response =
                restTemplate.getForEntity(url, SessionDto[].class);

        SessionDto[] sessions = response.getBody();
        EventRound eventRoundEntity = eventRoundRepository.findAllByRoundNumber(roundNumber)
                .orElseThrow(() -> new RuntimeException("Event Round not found for round " + roundNumber));

        for  (SessionDto sessionDto : sessions) {
            Date dateTime = sessionDto.sessionDate();
            SessionName sessionName = sessionNameRepository.getSessionNameById(sessionDto.sessionNameId());

            boolean exists = sessionRepository.existsByEventRoundAndSessionNameAndSessionDate(
                    eventRoundEntity, sessionName, dateTime);

            if (!exists) {
                Session sessionEntity = new Session(
                        eventRoundEntity,
                        dateTime,
                        sessionName
                );
                sessionRepository.save(sessionEntity);
            }
        }
    }

    public List<SessionResponseDto> findAll() {
        return sessionRepository.findAll()
                .stream()
                .map(sessionMapper::toSessionResponseDto)
                .collect(Collectors.toList()
                );
    }

    public SessionResponseDto findById(Integer id) {
        return sessionRepository.findById(id)
                .map(sessionMapper::toSessionResponseDto)
                .orElse(null);
    }
}
