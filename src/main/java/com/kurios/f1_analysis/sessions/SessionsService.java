package com.kurios.f1_analysis.sessions;

import com.kurios.f1_analysis.event_round.EventRoundRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SessionsService {

    private final  SessionsRepository sessionsRepository;

    private final SessionsMapper sessionsMapper;

    private final EventRoundRepository eventRoundRepository;


    public SessionsService(SessionsRepository sessionsRepository, SessionsMapper sessionsMapper, EventRoundRepository eventRoundRepository) {
        this.sessionsRepository = sessionsRepository;
        this.sessionsMapper = sessionsMapper;
        this.eventRoundRepository = eventRoundRepository;
    }

    public SessionsResponseDto create(SessionsDto sessionsDto) {
        var eventRound = eventRoundRepository.findAllById(sessionsDto.eventRoundId());
        var session = sessionsMapper.toSessions(sessionsDto, eventRound);
        var savedSession = sessionsRepository.save(session);
        var sessionResponseDto = sessionsMapper.toSessionsResponseDto(savedSession);
        return sessionResponseDto;
    }

    public List<SessionsResponseDto> findAll() {
        return sessionsRepository.findAll()
                .stream()
                .map(sessionsMapper::toSessionsResponseDto)
                .collect(Collectors.toList()
                );
    }
}
