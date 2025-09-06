package com.kurios.f1_analysis.session;

import com.kurios.f1_analysis.event_round.EventRoundRepository;
import com.kurios.f1_analysis.event_round.EventRoundResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SessionService {

    private final SessionRepository sessionRepository;

    private final SessionMapper sessionMapper;

    private final EventRoundRepository eventRoundRepository;


    public SessionService(SessionRepository sessionRepository, SessionMapper sessionMapper, EventRoundRepository eventRoundRepository) {
        this.sessionRepository = sessionRepository;
        this.sessionMapper = sessionMapper;
        this.eventRoundRepository = eventRoundRepository;
    }

    public SessionResponseDto save(SessionDto sessionDto) {
        var eventRound = eventRoundRepository.findAllById(sessionDto.eventRoundId());
        var session = sessionMapper.toSession(sessionDto, eventRound);
        var savedSession = sessionRepository.save(session);
        var sessionResponseDto = sessionMapper.toSessionResponseDto(savedSession);
        return sessionResponseDto;
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
